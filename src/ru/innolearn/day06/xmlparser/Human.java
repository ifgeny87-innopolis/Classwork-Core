package ru.innolearn.day06.xmlparser;

import org.w3c.dom.*;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Класс Человек
 */
class Human {
	protected String name;
	protected int age;

	/**
	 * Сериализация объекта в ноду
	 *
	 * @return Нода с описанием объекта
	 */
	Node serialize(Document document) throws IllegalAccessException {
		Class clazz = getClass();

		// получаю поля класса с иерархией
		Map<String, Field> clazzFields = ClassLib.getClassFields(clazz);

		Element result = document.createElement("object");
		result.setAttribute("type", clazz.getSimpleName());

		for (Field cf : clazzFields.values()) {
			cf.setAccessible(true);     // хакаю защищенные поля
			Element fn = document.createElement("field");
			Object value = cf.get(this);
			fn.setAttribute("type", value.getClass().getSimpleName());
			fn.setAttribute("name", cf.getName());
			fn.setAttribute("value", value.toString());
			result.appendChild(fn);
		}

		return result;
	}

	/**
	 * Десериализация объекта из ноды
	 *
	 * @param node Нода с описанием объекта
	 * @return Десериализованный объект
	 */
	static Object deserialize(Node node) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		// проверка имени ноды
		if (!"object".equals(node.getNodeName()))
			return null;

		// проверка типа объекта
		Node nodeType = node.getAttributes().getNamedItem("type");
		if (nodeType == null)
			return null;

		// определяю класс для объекта
		// это действие делаю раньше, а вдруг такого класса нету
		// пакет беру от корня
		String clazzName = ReflectXmlParser.class.getPackage().getName() + "." + nodeType.getNodeValue();
		Class clazz = Class.forName(clazzName);

		// получаю поля класса с иерархией
		Map<String, Field> clazzFields = ClassLib.getClassFields(clazz);

		// создаю объект
		Object result = clazz.newInstance();

		// теперь выполняю парсинг полей из ноды
		NodeList fields = node.getChildNodes();

		for (int i = 0; i < fields.getLength(); i++) {
			// обязательная проверка, может быть null
			if (!"field".equals(fields.item(i).getNodeName()))
				continue;

			// нода должна описывать три атрибута
			NamedNodeMap attrs = fields.item(i).getAttributes();
			Node type = attrs.getNamedItem("type");
			Node name = attrs.getNamedItem("name");
			Node value = attrs.getNamedItem("value");

			// check
			if (type == null || name == null || value == null) {
				new Exception("Для ноды указаны не все поля").printStackTrace();
				return true;
			}

			String fieldName = name.getNodeValue();

			// есть ли такое поле у объекта
			if (!clazzFields.containsKey(fieldName)) {
				new Exception(
						String.format("У объекта класса %s нет поля %s", clazzName, fieldName))
						.printStackTrace();
				continue;
			}

			// получаю значения полей
			String typeValue = type.getNodeValue();
			String valueValue = value.getNodeValue();

			Field field = clazzFields.get(fieldName);
			field.setAccessible(true);  // хакаю защищенные поля

			// теперь присваиваю значения
			switch (typeValue) {
				case "Integer":
					field.set(result, Integer.parseInt(valueValue));
					break;

				case "String":
					field.set(result, valueValue);
					break;
			}
		}

		return result;
	}

	@Override
	public String toString() {
		return "Human{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
