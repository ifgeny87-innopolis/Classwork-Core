package ru.innolearn.day14.hibernate.common;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innolearn.day14.hibernate.persistence.HibernateUtil;

import javax.persistence.Query;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created in project Inno-Classroom-Work in 16.01.17
 */
public class UserRoomsMain
{
	// logger
	private static final Logger log = LoggerFactory.getLogger(UserRoomsMain.class);

	public static void main(String[] args)
	{
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// ROOMS
			System.out.println("# Rooms:");
			session
					.createQuery("from Room")
					.list()
					.forEach(System.out::println);

			// TECH
			System.out.println("# Tech:");
			session.createQuery("from Tech")
					.list()
					.forEach(System.out::println);

			// USERS
			System.out.println("# Users:");
			session
					.createQuery("from User")
					.list()
					.forEach(System.out::println);

			// SINGLE USER
			System.out.println("# Single user:");
			Stream.of(session.load(User.class, 3))
					.forEach(u -> System.out.println(u + " | " + String.join(", ",
							u.getTech()
									.stream()
									.map(Tech::getName)
									.collect(Collectors.toList())
					)));
		}

		// close Hibernate
		HibernateUtil.getSessionFactory().close();
	}
}
