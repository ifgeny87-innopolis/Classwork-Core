package ru.innolearn.day27.springdata;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created in project Inno-Classroom-Work on 19.01.17
 */
//public class Main
//{
//	public static void main(String[] args)
//	{
////		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
////		ctx.load("classpath:appContext_27.xml");
////		ctx.refresh();
//
//		ApplicationContext appCtx = new ClassPathXmlApplicationContext("appContext_27.xml");
//
//		UserService userService = appCtx.getBean("userService", UserService.class);
//		Iterable<User> users = userService.findAll();
//		printAll(users);
//	}
//
//	private static void printAll(Iterable<User> $users) {
//		System.out.println("printAll: ");
//		for (User $user : $users) {
//			System.out.println($user);
//		}
//	}
//}
public class Main {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:appContext_27.xml");
		ctx.refresh();

		UserService service = ctx.getBean("jpaUserService", UserService.class);
		Iterable<User> users = service.findAll();
		printAll(users);

		users = service.findByName("Name1");
		printAll(users);

		users = service.findByNameAndAge("Name1", 25);
		printAll(users);
	}

	private static void printAll(Iterable<User> users) {
		System.out.println("printAll: ");
		for (User user : users) {
			System.out.println(user);
		}
	}
}