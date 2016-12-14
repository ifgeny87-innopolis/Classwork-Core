package ru.innolearn.tests.chat_over_tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by marina on 08.12.2016.
 */
public class ChatServer extends Thread {

	public static void main(String[] args) {
		String ip = "127.0.0.1";
		int port = 6666;

		// определяю свой IP адрес
		try {
			InetAddress addr = InetAddress.getLocalHost();
			ip = addr.getHostAddress();
		} catch (UnknownHostException e) {
			System.out.println("SERVER cannot get ip :(");
			e.printStackTrace();
		}

		System.out.println("SERVER start at " + ip + ":" + port);
		(new ChatServer(port)).start();
	}

	//----------------------------------

	private int port;

	private ServerSocket serverSocket;

	private List<Socket> clientSockets = new ArrayList<>();
	private List<ChatServerThread> threads = new ArrayList<>();

	public ChatServer(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		// 1. запускаю сервер
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			serverSocket = null;
			System.out.println("SERVER ERROR cannot start");
			e.printStackTrace();
			return;
		}

		// 2. жду клиентов и для каждого стартую Thread
		while (!isInterrupted()) {
			try {
				Socket socket = serverSocket.accept();
				clientSockets.add(socket);

				System.out.println("SERVER accept " + socket);

				ChatServerThread t = (new ChatServerThread(socket, this));
				threads.add(t);
				t.start();
			} catch (IOException e) {
				System.out.println("SERVER ERROR accept broken");
				e.printStackTrace();
			}
		}
	}

	/**
	 * Отправляет строку всем кроме одного
	 * @param line
	 * @param notMe
	 */
	public void sendLine(String line, ChatServerThread notMe) {
		for(ChatServerThread t : threads) {
			t.sendLine(line);
		}
	}

	/**
	 * Класс отдельного треда с клиентом
	 */
	class ChatServerThread extends Thread {

		private Socket socket;
		private ChatServer server;

		private DataInputStream streamIn;
		private DataOutputStream streamOut;

		private Scanner scanner;
		private PrintWriter writer;

		private Object monitor = new Object();

		private String clientName;

		ChatServerThread(Socket socket, ChatServer server) {
			this.socket = socket;
			this.server = server;

			try {
				streamIn = new DataInputStream(socket.getInputStream());
				scanner = new Scanner(streamIn);
				streamOut = new DataOutputStream(socket.getOutputStream());
				writer = new PrintWriter(streamOut);
			} catch (IOException e) {
				System.out.println("SERVER ERROR in stream accending with " + socket);
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (!isInterrupted()) {
				synchronized (monitor) {
					String line = scanner.nextLine();
					System.out.printf("C[%s]: %s\n", socket.getPort(), line);
					if (line.startsWith("upload "))
						uploadFile(line.substring(7));
					else if (line.startsWith("setname ")) {
						clientName = line.substring(8);
						server.sendLine("Welcome, " + clientName, this);
					} else
						// ответная реакция
						server.sendLine(clientName + ": " + line, this);
				}
			}
		}

		/**
		 * Команда отправляет клиенту строку с переводом строки
		 *
		 * @param command
		 */
		public void sendLine(String command) {
			writer.write(command + "\n");
			writer.flush();
		}

		/**
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

			// читаем байты, пишем в файл
			try (FileOutputStream fos = new FileOutputStream(fileName)) {
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
}
