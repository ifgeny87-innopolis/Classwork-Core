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
	static private Logger logger = LoggerFactory.getLogger(ChatClientThread.class);

	private DataInputStream streamIn;
	private DataOutputStream streamOut;

	private Scanner scanner;
	private PrintWriter writer;

	private boolean waitOkOnUpload = false;

	private Object monitor = new Object();

	ChatClientThread(Socket socket) {
		try {
			streamIn = new DataInputStream(socket.getInputStream());
			scanner = new Scanner(streamIn);
			streamOut = new DataOutputStream(socket.getOutputStream());
			writer = new PrintWriter(streamOut);
		} catch (IOException e) {
			System.out.println("CLIENT ERROR in stream accending with " + socket);
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// клиент постоянно ждет ответа от сервера
		while (!isInterrupted()) {
			synchronized (monitor) {
				String line = scanner.nextLine();
				System.out.println(line);

				if (waitOkOnUpload && line.equals("OK"))
					// если пришла команда OK и клиент желает отправить файл
					// тогда освобождаем monitor
					try {
						// жду пока выполнится другая команда
						System.out.println("Thread wait...");
						monitor.wait();
					} catch (InterruptedException e) {
						System.out.println("CLIENT ERROR while wait");
						e.printStackTrace();
					}
			}
		}
	}

	/**
	 * Команда отправляет серверу строку с переводом строки
	 *
	 * @param command
	 */
	void sendLine(String command) {
		writer.write(command + "\n");
		writer.flush();
	}

	/**
	 * Команда выполняет загрузку файла
	 */
	void uploadFile(String fileName) {
		// хочу передать файл
		waitOkOnUpload = true;

		File file = new File(fileName);
		String command = "upload " + file.getName() + " " + file.length();

		System.out.println(command + "...");
		sendLine(command);

		// жду пока поток освободиться и начну
		synchronized (monitor) {
			try (BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(file));) {
				// отправляю весь файл серваку
				byte[] buffer = new byte[1024];
				int len;
				while ((len = bis.read(buffer)) > 0) {
					streamOut.write(buffer, 0, len);
					streamOut.flush();
					System.out.println("Sended: " + len);
				}
			} catch (IOException e) {
				System.out.println("CLIENT ERROR file send");
				e.printStackTrace();
			}
			// передача окончена
			waitOkOnUpload = false;
			monitor.notify();
		}
	}
}