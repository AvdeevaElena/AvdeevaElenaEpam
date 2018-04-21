package SE05;

//Создать “универсальный” класс, позволяющий получить значение из любого properties-
//        файла. Физическое чтение файла должно происходить только один раз. Обработайте
//        следующие исключительные ситуации: нет файла *.properties, нет ключа в properties-файле.


import java.io.*;

import java.util.Properties;
import java.util.Scanner;

public class FileProperties {

    static String fileName;

    public static void runProperties() {
        try {
            Properties properties = getProperties(askPropertiesFile());
            while (true) {
                getValue(properties);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл Properties не отвечает");
            e.printStackTrace();
        }

    }


    public static void getValue(Properties properties) {
        String result = properties.getProperty(askPropertiesKey());
        System.out.println(result != null ? result : "Такого ключа не существует");
    }

    public static File askPropertiesFile() throws FileNotFoundException {
        System.out.println("Введите имя файла");
        Scanner scanner = new Scanner(System.in);
        return checkFile(scanner.next());
    }

    public static File checkFile(String filePath) throws FileNotFoundException {
        fileName =filePath;

        File file = new File(filePath);
        if (file.exists()) {
            return file;
        } else {
            throw new FileNotFoundException();
        }
    }

    public static String askPropertiesKey() {
        System.out.println("Введите ключ поиск");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static Properties getProperties(File file) {

        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(file)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
    public static void main(String[] args) {
        runProperties();
    }
}

