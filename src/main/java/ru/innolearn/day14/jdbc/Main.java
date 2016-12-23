package ru.innolearn.day14.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class Main {
	// logger
	static private Logger log = LoggerFactory.getLogger(Main.class);

	static {
	}

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			log.error("Mysql cannot be initialized", e);
			return;
		}

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",
					"test", "123");

			// insert

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
