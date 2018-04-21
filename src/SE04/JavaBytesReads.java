package SE04;
//Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова
//        языка Java это код содержит. Выведите эти слова и их количество в другой файл.
//        Используйте только байтовые потоки ввода-вывода.

import java.util.*;
import java.lang.*;
import java.io.*;


public class JavaBytesReads {
    static String outFile;


    public static void countKeywordsAndWriteToByteFile(String fileToCountPath, String outputFilePath) throws IOException {

        String fileContent = new String(getBytesFromFile(fileToCountPath));
        stringToFile(KeyWords.countJavaKeywords(fileContent).toString(), outputFilePath);
    }


    private static byte[] getBytesFromFile(String filePath) throws IOException {
        try (FileInputStream in = new FileInputStream(filePath);
             ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[0xFFFF];
            for (int len; (len = in.read(buffer)) != -1; ) {
                os.write(buffer, 0, len);
            }
            os.flush();
            return os.toByteArray();
        }
    }


    private static void stringToFile(String content, String fileName) {
        byte[] contentBytes = content.getBytes();

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(contentBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {

        String inFile = "javaSetWords.txt";
        String outFile = "javaAnswer.txt";
        try {
          JavaBytesReads.countKeywordsAndWriteToByteFile(inFile,outFile);

        }
         catch(IOException e)  {
            e.printStackTrace();
        } ;

        System.out.println( "Проверяй javaAnswer.txt");


    }
}
