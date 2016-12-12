package ru.innolearn.day06.xmlparser;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.*;

/**
 * Программа умеет сериализовать и десериализовать XML файлы.
 *
 * Особенности программы:
 * - сериализация и десериализация объектов с сохранением иерархии классов
 * - определение ошибок стрктуры XML файла при десериализации
 * - масштабируется при добавлении новых классов пакета
 * - если проблемы с обработкой ошибок, но это зависит от правильности входного XML файла
 *
 * Работа программы:
 * 1. Выполняет десериализацию обеъктов из файла Humans.xml
 * 2. Запоминает список объектов
 * 3. Выполняет сериализацию объектов в файл Result.xml
 */
public class ReflectXmlParser {
	/**
	 * Точка входа программы
	 *
	 * @param args Аргументы консоли
	 * @throws ParserConfigurationException
	 * @throws FileNotFoundException
	 * @throws TransformerConfigurationException
	 */
	public static void main(String[] args) throws ParserConfigurationException, FileNotFoundException, TransformerConfigurationException {
		documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		// читаю из файла
		Object[] humans = deserializeFile("files\\Humans.xml");

		// вывожу
		for (Object human : humans)
			System.out.println(human);

		// сохраняю в файл
		serializeList(humans, "files\\Result.xml");
	}

	// билдер документов
	static private DocumentBuilder documentBuilder;

	/**
	 * Десериализация файла XML
	 *
	 * @param inputFilename Имя входного файла
	 * @return Список десериализованных объектов
	 */
	static private Object[] deserializeFile(String inputFilename) {
		List<Object> result = new ArrayList<>();

		try {
			Document doc = documentBuilder.parse(inputFilename);

			Node root = doc.getFirstChild();    // <list>

			// check root
			if (!"list".equals(root.getNodeName())) {
				throw new IllegalAccessException("Root node name must be `list`");
			}

			// для каждого детишки парсим объект
			NodeList nodes = root.getChildNodes();
			for (int i = 0; i < nodes.getLength(); i++) {
				Object object = Human.deserialize(nodes.item(i));
				if (object != null)
					result.add(object);
			}
		} catch (IOException | SAXException | IllegalAccessException | ClassNotFoundException | InstantiationException e) {
			e.printStackTrace();
		}

		return result.toArray();
	}

	/**
	 * Выполняет сериализацию списка объектов
	 *
	 * @param humans      Список объектов для сериализации
	 * @param outFilename Имя выходного файла
	 * @throws TransformerConfigurationException
	 * @throws FileNotFoundException
	 */
	static private void serializeList(Object[] humans, String outFilename) throws TransformerConfigurationException, FileNotFoundException {
		// создаю новый документ
		Document document = documentBuilder.newDocument();

		// создаю корневую ноду
		Element list = document.createElement("list");
		document.appendChild(list);

		// сериализую все объекты и добавляю в корневую ноду
		Arrays.stream(humans).forEach(h -> {
			try {
				list.appendChild(((Human) h).serialize(document));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		});

		// сохраняю документ в XML файл
		Transformer tr = TransformerFactory.newInstance().newTransformer();
		DOMSource domSource = new DOMSource(document);

		try (FileOutputStream fos = new FileOutputStream(outFilename)) {
			StreamResult sr = new StreamResult(fos);
			tr.transform(domSource, sr);
		} catch (TransformerException | IOException e) {
			e.printStackTrace();
		}
	}

}

