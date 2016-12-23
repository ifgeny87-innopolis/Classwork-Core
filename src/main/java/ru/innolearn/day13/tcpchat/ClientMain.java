package ru.innolearn.day13.tcpchat;

import org.slf4j.*;

import java.util.Scanner;

/**
 * Программа запускает чат-клиент
 *
 * Created by marina on 08.12.2016.
 */
public class ClientMain {
	// logger
	static private Logger log = LoggerFactory.getLogger(ClientMain.class);

	public static void main(String[] args) {
		String name = null;
		String hostname = null;
		int port = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.print("Hello. ");

		// узнаю имя пользователя
		while (true) {
			System.out.println("What's your name?");
			name = scanner.nextLine();
			if (name.length() > 0)
				break;
			System.err.println("Bark! Wrong name.");
		}

		// узнаю строку подключения
		while (true) {
			System.out.println("Type connection string [host:port].");
			String[] parts = scanner.nextLine().split(":");
			if (parts.length != 2) {
				System.err.println("Bark! Wrong connection string.");
				continue;
			}
			hostname = parts[0];
			port = Integer.parseInt(parts[1]);
			break;
		}

		// создаю и стартую клиента
		ChatClient client = new ChatClient(hostname, port, name);
		client.start();
	}
}
