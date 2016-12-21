package ru.innolearn.day13.tcpchat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by marina on 08.12.2016.
 */
class ChatServerThread extends Thread {
	// logger
	private static Logger log = LoggerFactory.getLogger(ChatServerThread.class);

	private Socket socket;
	private ChatServer server;

	private DataInputStream streamIn;

	private Scanner scanner;
	private PrintWriter writer;

	private Object monitor = new Object();

	private String clientName;

	/** constructor **/
	ChatServerThread(Socket socket, ChatServer server) {
		this.socket = socket;
		this.server = server;

		try {
			streamIn = new DataInputStream(socket.getInputStream());
			scanner = new Scanner(streamIn);
			DataOutputStream streamOut = new DataOutputStream(socket.getOutputStream());
			writer = new PrintWriter(streamOut);
		} catch (IOException e) {
			log.error("SERVER ERROR in stream accending with " + socket, e);
		}
	}

	@Override
	public void run() {
		while (!isInterrupted()) {
			synchronized (monitor) {
				String line = scanner.nextLine();
				System.out.printf("C[%s]: %s\n", socket.getPort(), line);

				if (line.startsWith("upload ")) {
					// клиент может сказать "прими файл"
					// и тогда сервер должен принять файл
					uploadFile(line.substring(7));
				} else if (line.startsWith("setname ")) {
					// а еще клиент может изменить имя
					// и сервер запомнит новое имя клиента
					clientName = line.substring(8);
					server.sendLine("Welcome, " + clientName, this);
				} else
					// иначе сервер думает, что клиент просто пишет сообщение в чат
					server.sendLine(clientName + ": " + line, this);
			}
		}
	}

	/**
	 * Команда отправляет клиенту строку
	 * В конце отправляет символ перевода строки
	 *
	 * @param command
	 */
	public void sendLine(String command) {
		writer.write(command + "\n");
		writer.flush();
	}

	/**
	 * Принимаем файл от клиента
	 *
	 * @param command
	 */
	void uploadFile(String command) {
		String[] parts = command.split(" ");

		// проверяем команду
		String fileName = parts[0];
		int size = Integer.parseInt(parts[1]);

		// здесь мы находимся все еще внутри sync(monitor)
		// поэтому поток читать будем сами в этот методе

		sendLine("OK");

		// читаем байты от клиента, пишем байты в файл
		try (FileOutputStream fos = new FileOutputStream(
				new File("uploads", fileName))) {
			int readed = 0;
			byte[] buffer = new byte[1024];
			while (readed < size) {
				int len = Math.min(size - readed, buffer.length);
				int r = streamIn.read(buffer, 0, len);
				readed += r;
				fos.write(buffer, 0, r);
			}
		} catch (IOException e) {
			System.out.println("SERVER ERROR file save");
			e.printStackTrace();
			sendLine("ERROR");
			return;
		}

		// файл принят, подтвердим
		sendLine("OK");

	}
}
