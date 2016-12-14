package ru.innolearn.day03.exceptions;

import java.io.FileNotFoundException;

/**
 * Created by marina on 07.12.2016.
 */
public class ExceptionTest {
    public static void main(String[] args) throws FileNotFoundException {
        ExceptionThrower ext = new ExceptionThrower();
        try {
            ext.doSome();
        } catch (FileNotFoundException e) {
            System.out.println("catch");
            throw e;
        } finally {
            System.out.println("finally");
            // Если вызвать исключение или return,
            // то они перетрет всю нужную информацию
            // Поэтому:
            // 1. не стоит писать return
            // 2. не стоит писать exception, или оборачивать в другой try..catch
            throw new RuntimeException(); // FIXME ошибка в finally перетрет все!
            // return;
        }
//        System.out.println("end");
    }

    /**
     * class ExceptionThrower
     */
    static class ExceptionThrower {
        public void doSome() throws FileNotFoundException {
            throw new FileNotFoundException();
        }
    }
}
