package ru.innolearn.day15.classloaders;

import org.slf4j.*;
import ru.innolearn.day15.classloaders.modules.Executable;

import javax.tools.*;
import java.io.*;
import java.util.Scanner;

/**
 * Программа умеет динамически создавать .java файлы, компилировать их в .class файлы,
 * а еще умеет классы из байт-кода и запускать объекты на выполнение.
 *
 * На сегодня программа работает по следующему сценарию:
 * 1) Получает от пользователя имя класса и строку с сообщением
 * 2) Создает наследуемый от Executable класс с этим именем с .java файл
 * 3) Запускает компилятор и компилирует этот файл, получает .class
 * 4) ClassLoader загружает этот файл в байт-массив и парсит байт-код
 * 5) В методе execute объект должен вывести в System.out свое имя и сообщение
 *
 * Created in project Inno-Classroom-Work in 23.12.2016
 */
public class Main {
	// logger
	private static final Logger log = LoggerFactory.getLogger(Main.class);

	// путь где .java и .class лежат
	private static final String classPath = "c:\\temp\\";

	private static ModuleLoader moduleLoader = new ModuleLoader(classPath,
			ClassLoader.getSystemClassLoader());

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, InterruptedException {
		try (Scanner scan = new Scanner(System.in)) {
			while (true) {
				System.out.println("Введите имя нового класса или exit:");
				String line = scan.nextLine().trim();

				if ("exit".equalsIgnoreCase(line))
					break;

				if (line.length() == 0) {
					// FIXME: 23.12.2016 добавить валидацию имени класса
					System.out.println("Ай-ай-ай, нельзя использовать пустое имя");
					System.out.println("Давай попробуем еще раз");
					continue;
				}

				String className = line;

				System.out.println("Какую строку должен вывести объект:");
				line = scan.nextLine();

				log.info("Сохраняем и компилим");
				saveJavaNCompile(className, line);

				log.info("Пробуем загрузить теперь и выполнить");
				Class clazz = moduleLoader.loadClass(className);
				Executable execute = (Executable) clazz.newInstance();

				log.info("Запускаем");
				execute.execute();
			}
		}
	}

	/**
	 * Метод получает имя класса на вход и строку с сообщением.
	 * Далее создает .java файл, в котором динамически создает класс и после чего компилирует на лету.
	 *
	 * @param className Имя класса без пакета
	 * @param line      Строка с сообщением
	 * @throws IOException Возможны ошибки при сохранении файла
	 */
	static void saveJavaNCompile(String className, String line) throws IOException {
		String fileName = classPath + className + ".java";
		String java = "public class " + className + " implements ru.innolearn.day15.classloaders.modules.Executable {\n" +
				"\n" +
				"\t@Override\n" +
				"\tpublic void execute() {\n" +
				"\t\tSystem.out.println(\"Module `" + className + "` says `" + line + "`!\");\n" +
				"\t}\n" +
				"}";

		try (OutputStream os = new FileOutputStream(fileName)) {
			os.write(java.getBytes());
		}

		// Variant 1 - встроенным компилятором
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		compiler.run(null, null, null, fileName);

		// Variant 2 - через консоль
//		String cmd = "cmd /C cd c:\\temp && \"%JAVA_HOME%\\bin\\javac\" -classpath c:\\Projects\\java\\Inno-Classroom-Work\\build\\classes\\main\\ " + fileName;
//		log.info("Cmd: " + cmd);

//		Process proc = Runtime.getRuntime().exec(cmd);
//		while (proc.isAlive())
//			Thread.sleep(100);
	}
}
