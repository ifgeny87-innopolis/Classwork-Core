package ru.innolearn.day14.hibernate.common;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innolearn.day14.hibernate.persistence.HibernateUtil;

import java.util.List;
import java.util.Random;

public class Main1 {
	// logger
	static private Logger log = LoggerFactory.getLogger(Main1.class);

	public static void main(String[] args) {
		log.info("Starts test One");

		Session session = HibernateUtil.getSessionFactory().openSession();

		{
			session.beginTransaction();

			Stock stock = new Stock();
			stock.setCode("" + new Random().nextInt());
			stock.setName("STOCK_" + new Random().nextInt());

			session.save(stock);
			session.getTransaction().commit();

			// get
			List<Stock> list = session.createQuery("from Stock").list();

			for (Stock st : list) {
				System.out.println(st.toString("%10s\t| %20s\t| %20s"));
			}
		}

		//============================>

		log.info("Starts test Two");

		{
			session.beginTransaction();

			Stock2 stock2 = new Stock2();
			stock2.setCode("" + new Random().nextInt());

			session.save(stock2);
			session.getTransaction().commit();

			// get
			List<Stock2> list = session.createQuery("from Stock2").list();

			for (Stock2 st : list) {
				System.out.println(st.toString("%10s\t| %20s\t| %20s"));
			}
		}

		session.close();
	}
}