package ru.innolearn.day13.tcpchat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marina on 08.12.2016.
 */
public class ChatServer extends Thread {
	// logger
	static private Logger log = LoggerFactory.getLogger(ChatServer.class);

	// порт сервера
	private int port;

	// список сокетов-клиентов
	private List<Socket> clientSockets = new ArrayList<>();

	// потоки работы с клиентами
	private List<ChatServerThread> threads = new ArrayList<>();

	/** constructor **/
	public ChatServer(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			while (!isInterrupted()) {
				try {
					// жду клиента
					Socket socket = serverSocket.accept();
					clientSockets.add(socket);

					log.info("SERVER accept " + socket);

					// стартую отдельный тред для клиента
					ChatServerThread t = new ChatServerThread(socket, this);
					threads.add(t);
					t.start();
				} catch (IOException e) {
					log.error("SERVER accept error", e);
				}
			}
		} catch (IOException e) {
			log.error("SERVER error", e);
		}
	}

	/**
	 * Отправляет строку всем кроме одного
	 *
	 * @param line
	 * @param notMe
	 */
	public void sendLine(String line, ChatServerThread notMe) {
		// FIXME надо исключить из списка одного клиента
		// UPDATE а надо ли его исключать? пусть все клиенты получают сообщение
		for (ChatServerThread t : threads) {
			t.sendLine(line);
		}
	}
}
