package ru.innolearn.day08.myappender;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Этот аппендер после выполнения программы выполняет вывод всех ошибок
 */
public class MailAppender extends AppenderSkeleton {
	List<String> events = new ArrayList<>();

	public MailAppender() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				eventOut();
			}
		});
	}

	@Override
	protected void append(LoggingEvent event) {
		// буду копить список евентов
		events.add(getLayout().format(event));
		// промежуточные евенты тоже буду выводить
		System.out.println("8) Kitty says: Vzzzhuh... " + event.getRenderedMessage());
	}

	@Override
	public void close() {
	}

	@Override
	public boolean requiresLayout() {
		return true;
	}

	/**
	 * Метод берет и выводит весь лог, который накопился
	 * Не самый лучший способ хукать завершение работы, но что делать, ум он пытливый
	 */
	public void eventOut() {
		System.out.println("+--------------------------------------------------");
		System.out.println("| Vzhuh...");
		System.out.println("+--------------------------------------------------");
		for (String line : events) {
			System.out.print("| " + line);
		}
		System.out.println("+--------------------------------------------------");
	}
}
