package ru.innolearn.day03.serialize;

import java.io.*;
import java.util.*;

/**
 * Created by marina on 07.12.2016.
 * <p>
 * Реализовать программу со следующим функционалом:
 * 1.  Возможность ввода команд из консоли
 * 2.  Возможность считывания информации из файла (путь к файлу задается параметром команды) и построения на основе этой информации коллекции объектов. Пример команды – parse input.txt
 * 3.  Возможность сериализовать объекты из коллекции в выходной файл. Пример команды – serialize output.data
 * 4.  Возможность десериализовать объекты из файла и вывести их на печать в консоль. Пример команды – deserialize output.data
 * <p>
 * Пример пользовательского файла input.txt:
 * Name=Ivan age=20
 * Name=John age=30
 * Name=Kate age=25
 * Name=Kelly age=40
 * Name=Sergey age=35
 */
public class ParseProgram {

    public static void main(String[] args) {
        (new ParseProgram()).run();
    }

    // в этом буфере будем хранить результат команды parse
    private List<Human> buffer;

    void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // приглашение на ввод
            System.out.print("> ");

            // читает команду
            String command = scanner.next();

            // для указанной команды выполняет действие
            switch (command) {
                case "parse":
                    parse(scanner.next());
                    break;

                case "serialize":
                    serialize(scanner.next());
                    break;

                case "deserialize":
                    deserialize(scanner.next());
                    break;

                case "exit":
                    break;

                default:
                    System.out.println("Command " + command + " not found");
            }

            // чтоб обработать перевод строки
            scanner.nextLine();

            if (command.equals("exit"))
                break;
        }
    }

    /**
     * Парсит файл и заполняет буфер
     *
     * @param fileName
     */
    void parse(String fileName) {
        buffer = loadText(fileName);
    }

    /**
     * Сериализацет буфер в файл
     *
     * @param fileName
     */
    void serialize(String fileName) {
        saveData(buffer, fileName);
    }

    /**
     * Дисериализует файл и выводит на печать
     *
     * @param fileName
     */
    void deserialize(String fileName) {
        List<Human> humans = loadData(fileName);
        for (Human h : humans) {
            System.out.println(h);
        }
    }

    /**
     * Парсит текстовый файл с данными и возвращает массив новых объектов
     *
     * @param fileName
     * @return
     */
    List<Human> loadText(String fileName) {
        // результат
        List<Human> humans = new ArrayList<>();

        // Scanner поможет читать по строкам
        try (InputStream is = new FileInputStream(fileName);
             Scanner scan = new Scanner(is)) {
            //
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String[] parts = line.split(" ");
                Human human = new Human();

                for (String part : parts) {
                    String[] keyValue = part.split("=");
                    switch (keyValue[0]) {
                        case "name":
                            human.setName(keyValue[1]);
                            break;

                        case "surname":
                            human.setSurname(keyValue[1]);
                            break;

                        case "age":
                            human.setAge(Integer.parseInt(keyValue[1]));
                            break;
                    }
                }

                humans.add(human);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return humans;
    }

    /**
     * Метод сериализует объекты из буфера и записывает в файл
     *
     * @param humans
     * @param fileName
     */
    void saveData(List<Human> humans, String fileName) {
        try (OutputStream os = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(os)) {

            // сначала запишу количество объектов в файле
            oos.writeInt(humans.size());

            // теперь сериализую и записываю каждуй объект
            for (Human h : humans)
                oos.writeObject(h);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод читает и дисериализует объекты из указанного файла
     *
     * @param fileName
     * @return
     */
    List<Human> loadData(String fileName) {
        List<Human> result = new ArrayList<>();

        try (InputStream is = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            // читаю количество объектов в файле
            int count = ois.readInt();

            // теперь читаю count объектов
            for (int i = 0; i < count; i++)
                result.add((Human) ois.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }
}