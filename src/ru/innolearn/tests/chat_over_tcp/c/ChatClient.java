import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by marina on 08.12.2016.
 */
public class ChatClient extends Thread {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name = null;
		String hostname = null;
		int port = 0;

		System.out.print("Hello. ");

		while(true) {
			System.out.println("What's your name?");
			name = scanner.nextLine();
			if(name.length() > 0)
				break;
			System.out.println("Bark! Wrong name.");
		}

		while (true) {
			System.out.println("Type connection string [host:port].");
			String[] parts = scanner.nextLine().split(":");
			if(parts.length != 2) {
				System.out.println("Bark! Wrong connection string.");
				continue;
			}
			hostname = parts[0];
			port = Integer.parseInt(parts[1]);
			break;
		}

		(new ChatClient(hostname, port, name)).start();
	}

	//----------------------------------

	private String hostname;
	private int port;
	private String name;

	private Socket socket;
	private Scanner console;

	ChatClient(String hostname, int port, String name) {
		this.hostname = hostname;
		this.port = port;
		this.name = name;
	}

	@Override
	public void run() {
		// 1. Пробую соединиться с сервером
		while (socket == null) {
			try {
				System.out.println("CLIENT try connect to " + hostname + ":" + port + "...");
				socket = new Socket(hostname, port);
			} catch (IOException e) {
				socket = null;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}

		System.out.println("CLIENT connected to " + socket);

		// создаю клиента, который будет читать и отправлять команды серверу
		ClientThread client = new ClientThread(socket);
		client.start();

		// сообщу серверу свое имя
		client.sendLine("setname " + name);

		console = new Scanner(System.in);

		try {
			// в этом цикле постоянно читаю команды из консоли
			// и отправляю их серверу
			while (!isInterrupted()) {
				String command = console.nextLine();

				if (command.startsWith("upload "))
					client.uploadFile(command.substring(7));
				else
					client.sendLine(command);
			}
		} catch (Exception e) {
			System.out.println("CLIENT ERROR happens");
			e.printStackTrace();
		}
	}

	/**
	 * Класс клиента
	 */
	class ClientThread extends Thread {

		private DataInputStream streamIn;
		private DataOutputStream streamOut;

		private Scanner scanner;
		private PrintWriter writer;

		private boolean waitOkOnUpload = false;

		private Object monitor = new Object();

		ClientThread(Socket socket) {
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
}
