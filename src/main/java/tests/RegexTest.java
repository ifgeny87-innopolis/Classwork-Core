package tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by marina on 07.12.2016.
 */
public class RegexTest {
    public static void main(String[] args) {
        String[] lines = {
                "Name=Starik Age=26 class=Designer",
                "Name=Buddy email=buddy@mail.com web=http://site.com",
                "parse -f input.txt",
                "run -name folder/file.ext -w 1000 -q",
                "makarov_es@mail.ru,i@guy.com",
                "ivanov.ivan+work@mail.email.ru a@b.cd",
                "#12dbef",
                "#rgba12",  // wrong color
                "#1234",    // wrong color too
                "#edf",
        };

//        testTags(lines);
//        testCommands(lines);
        testEmail(lines);
//        testReplace(lines);
        testColor(lines);
    }

    static void testTags(String[] lines) {
        // пробую через регулярки вытащить поля и значения
        System.out.println("# Regex tags test");

        Pattern regexp = Pattern.compile("([\\w]+)=([\\w\\.@\\/\\:]+)");

        for (String line : lines) {
            Matcher m = regexp.matcher(line);

            if (!m.find())
                continue;

            System.out.println("Parse line: " + line);

            do {
                System.out.printf("\t- %s = '%s'\n", m.group(1), m.group(2));
            }
            while (m.find());
        }
    }

    static void testCommands(String[] lines) {
        // пробую через регулярки вытащить поля и значения
        System.out.println("# Commands test");

        Pattern regexp = Pattern.compile("(-[\\w]+) ([\\w\\.\\:\\/@]+)");

        for (String line : lines) {
            int k =line.indexOf(' ');

            Matcher m = regexp.matcher(line);

            if (!m.find())
                continue;

            System.out.println("Parse line: " + line);

            do{
                System.out.println("\t" + m.group());
                for (int i = 1; i <= m.groupCount(); i++)
                    System.out.println("\t\t" + m.group(i));
            }
            while (m.find());
        }
    }

    /**
     * Проверка почты.
     * В одной строке может быть указано несколько адресов.
     * @param lines
     */
    static void testEmail(String[] lines)
    {
        //
        System.out.println("# Email matches test");

        Pattern pattern = Pattern.compile("([a-z0-9+_\\.-]+)@([a-z0-9_\\.-]+)\\.([a-z]{2,6})", Pattern.CASE_INSENSITIVE);

        for(String line: lines) {
            Matcher m = pattern.matcher(line);
            if(!m.find())
                continue;

            System.out.println("Matches in line: " + line);

            do {
                System.out.println("\t" + m.group());
            }
            while (m.find());
        }
    }

    static void testReplace(String[] lines)
    {

    }

    /**
     * Тестирую регулярки для поиска цветов.
     * А также в методе выполняется быстрая проверка по маске.
     * @param lines
     */
    static void testColor(String[] lines)
    {
        System.out.println("# Color test");

        String mask = "#?([0-9a-f]{6}|[0-9a-f]{3})";

        for(String line:lines) {
            if(Pattern.matches(mask, line))
                System.out.println("This is color : " + line);
        }
    }
}
