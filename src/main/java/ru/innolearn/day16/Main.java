package ru.innolearn.day16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.innolearn.day16.handlers.DataHandler;
import ru.innolearn.day16.io.DbUploader;

/**
 * Created in project Inno-Classroom-Work in 26.12.2016
 */
public class Main {
	public static void main(String[] args) {
		//////////////////////// 1 способ
		// Пример работы с бином
		{
			ApplicationContext appCtx = new ClassPathXmlApplicationContext(
					new String[]{"applicationContext_16_1.xml"});

			System.out.println("# 1");
			// Пропертя можно прописать в конфиге, а можно вручную забивать

			DataHandler dataHandler1 = (DataHandler) appCtx.getBean("dataHandler1");
			// все еще можно вручную указать uploader/downloader
			dataHandler1.setUploader(new DbUploader());
			dataHandler1.handleData("src", "dest");

			// А теперь проверю что это Singleton (смотри атрибут scope в applicationContext_16_1.xml)
			DataHandler dataHandlerCopy = (DataHandler) appCtx.getBean("dataHandler1");
			System.out.println("Is singleton? " + (dataHandlerCopy == dataHandler1));
		}

		//////////////////////// 2 и 3 способ
		// 2 и 3 способ похожи, разница в способе поиска бинов - по имени и типу
		{
			ApplicationContext appCtx = new ClassPathXmlApplicationContext(
					new String[]{"applicationContext_16_2.xml"});

			System.out.println("# 2");
			// Поиск бинов в конфиге по имени
			DataHandler dataHandler2 = (DataHandler) appCtx.getBean("dataHandler2");
			dataHandler2.handleData("src", "dest");

			System.out.println("# 3");
			// Поиск бинов в конфиге по типу
			DataHandler dataHandler3 = (DataHandler) appCtx.getBean("dataHandler3");
			dataHandler3.handleData("src", "dest");
		}

		//////////////////////// 4 способ
		// А теперь свойства автоматически создаются по типу
		{
			ApplicationContext appCtx = new ClassPathXmlApplicationContext(
					new String[]{"applicationContext_16_4.xml"});

			// Отработаем 2 и 3 способ но уже без указания бинов, контекст умеет искать по пакету

			System.out.println("# 4-2'");
			DataHandler dataHandler2 = (DataHandler) appCtx.getBean("dataHandler2");
			dataHandler2.handleData("src", "dest");

			System.out.println("# 4-3'");
			DataHandler dataHandler3 = (DataHandler) appCtx.getBean("dataHandler3");
			dataHandler3.handleData("src", "dest");
		}
	}
}
