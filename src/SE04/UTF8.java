package SE04;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;


//Дан файл, содержащий буквы текст на кириллице. Кодировка файла utf-8.
//        Прочитайте информацию из файла и перепишите ее в файл в кодировкой utf-16.
public class UTF8 {

    public static void main(String[] args) {
        String fileToRead  = "utf8.txt";
        String fileToWrite = fileToRead.concat("utf16.txt");

        try {
            Files.write(Paths.get(fileToWrite), Files.readAllLines(Paths.get(fileToRead), StandardCharsets.UTF_8),
                    StandardCharsets.UTF_16);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
