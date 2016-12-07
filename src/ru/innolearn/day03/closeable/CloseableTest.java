package ru.innolearn.day03.closeable;

import java.io.*;

/**
 * Created by marina on 07.12.2016.
 *
 * Играемся с try(resource) {...}
 */
public class CloseableTest {
    public static void main(String[] args) throws Exception {
        /*
         * 1 способ - очень длинный и долго писать
         * Я хочу просто считать пару строк из стрима, а мне приходится описывать очень большую конструкцию
         */

        System.out.println("# 1");

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("");
            inputStream.read(null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStream !=null) {
                    inputStream.close();
                }
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }

        /*
         * 2 способ - поменьше кода
         * Этот способ уже лучше. Такая возможность появилась с java 1.7
         */
        System.out.println("# 2");

        try (InputStream inputStream2 = new FileInputStream("")) {
            inputStream2.read(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * 3 способ - проверить своим Closable классом
         *
         */
        System.out.println("# 3");

        try (Closeable myRes = new MyResource();
             Closeable myRes2 = new MyResource();) {
            System.out.println("try");
        }
        catch(Exception e)
        {
            System.out.println("catch");
            throw e;
        }
        finally {
            System.out.println("finally");
        }
        System.out.println("end");
    }

    static class MyResource implements Closeable {

        @Override
        public void close() throws IOException {
            System.out.println("!!! close here !!! " + this);
            throw new RuntimeException();
        }
    }
}
