package ru.innolearn.day13.tcpchat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by marina on 08.12.2016.
 */
public class ChatClient extends Thread {
	// logger
	static private Logger log = LoggerFactory.getLogger(ChatClient.class);

	private String hostname;
	private int port;
	private String name;

	private Socket socket;
	private Scanner console;

	/** constructor **/
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
				log.info("CLIENT try connect to " + hostname + ":" + port + "...");
				socket = new Socket(hostname, port);
			} catch (IOException e) {
				// выводить ошибку не надо, просто сервер еще не поднялся
				// FIXME по идее надо поставить счетчик попыток
				socket = null;
				try {
					// через секунду попробую снова
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					log.error("CLIENT SLEEP failed", e1);
				}
			}
		}

		log.info("CLIENT connected to " + socket);

		// создаю клиента, который будет читать и отправлять команды серверу
		ChatClientThread client = new ChatClientThread(socket);
		client.start();

		// сообщу серверу имя пользователя
		client.sendLine("setname " + name);

		// сканер для консоли
		console = new Scanner(System.in);

		try {
			// в этом цикле этого потока постоянно читаю строки из консоли
			// каждую новую строку отправляю серверу
			while (!isInterrupted()) {
				String command = console.nextLine();

				if (command.startsWith("upload ")) {
					// пользователь хочет передать файл серверу
					// ну ладно, переходим в режим передачи
					client.uploadFile(command.substring(7));
				}
				else {
					// иначе просто отправляем сообщение как текст
					client.sendLine(command);
				}
			}
		} catch (Exception e) {
			// ошибка сокета прилетит сюда
			log.error("CLIENT ERROR happens", e);
		}
	}
}
