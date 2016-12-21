package ru.innolearn.day13.tcpchat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by marina on 08.12.2016.
 */
public class ChatClient extends Thread {
	private String hostname;
	private int port;
	private String name;

	private Socket socket;
	private Scanner console;

	/** constructor  **/
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
		ChatClientThread client = new ChatClientThread(socket);
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
}
