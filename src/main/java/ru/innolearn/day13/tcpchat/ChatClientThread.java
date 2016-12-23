package ru.innolearn.day13.tcpchat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Поток клиента чата
 *
 * Created by marina on 08.12.2016.
 */
class ChatClientThread extends Thread {
	// logger
	static private Logger log = LoggerFactory.getLogger(ChatClientThread.class);

	private Socket socket;

	private DataOutputStream streamOut;
	private PrintWriter writer;

	private boolean waitOkOnUpload = false;

	// монитор нужен для синхронизации операции передачи файла и отправки текстового сообщения
	private Object monitor = new Object();

	/** constructor **/
	ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			DataInputStream streamIn = new DataInputStream(socket.getInputStream());
			Scanner scanner = new Scanner(streamIn);
			streamOut = new DataOutputStream(socket.getOutputStream());
			writer = new PrintWriter(streamOut);

			// клиент постоянно ждет ответа от сервера
			while (!isInterrupted()) {
				synchronized (monitor) {
					// жду команду от сервера и вывожу ее сразу же в консоль
					String line = scanner.nextLine();
					System.out.println(line);

					if (waitOkOnUpload && line.equals("OK"))
						// если пришла команда OK и клиент желает отправить файл
						// тогда освобождаем monitor
						try {
							// жду пока выполнится другая команда
							log.info("Thread wait...");
							monitor.wait();
						} catch (InterruptedException e) {
							log.error("CLIENT ERROR while wait", e);
						}
				}
			}
		} catch (IOException e) {
			log.error("CLIENT ERROR in stream accending with " + socket, e);
		}
	}

	/**
	 * Отправляет серверу строку с переводом строки
	 *
	 * @param command
	 */
	void sendLine(String command) {
		writer.write(command + "\n");
		writer.flush();
	}

	/**
	 * Переключение в режим передачи файла
	 */
	void uploadFile(String fileName) {
		// хочу передать файл
		waitOkOnUpload = true;

		File file = new File(fileName);
		String command = "upload " + file.getName() + " " + file.length();

		System.out.println(command + "...");
		sendLine(command);

		// жду пока монитор освободится освободится и начну
		synchronized (monitor) {
			// FIXME добавить проверку на существование файла
			try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
				// отправляю весь файл серваку
				byte[] buffer = new byte[0x200];
				int len;

				// пока файл читается, читаю и отправляю кусками
				while ((len = bis.read(buffer)) > 0) {
					streamOut.write(buffer, 0, len);
					streamOut.flush();
					log.info("Sends part with length " + len);
				}
			} catch (IOException e) {
				log.error("CLIENT ERROR file send", e);
			}
			// передача окончена
			waitOkOnUpload = false;
			monitor.notify();
		}
	}
}