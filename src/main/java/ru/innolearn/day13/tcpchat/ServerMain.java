package ru.innolearn.day13.tcpchat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Программа запускает чат-сервер
 *
 * Created by marina on 08.12.2016.
 */
public class ServerMain {
	// logger
	static private Logger log = LoggerFactory.getLogger(ServerMain.class);

	public static void main(String[] args) {
		log.info("Chat server starts...");

		String ip = "127.0.0.1";
		int port = 6666;

		// определяю свой IP адрес
		try {
			InetAddress addr = InetAddress.getLocalHost();
			ip = addr.getHostAddress();
		} catch (UnknownHostException e) {
			log.error("SERVER cannot get outdoor ip :(", e);
		}

		System.out.println("SERVER starts at " + ip + ":" + port);

		ChatServer server = new ChatServer(port);
		server.start();
	}
}
