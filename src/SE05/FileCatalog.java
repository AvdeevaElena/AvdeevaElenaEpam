package SE05;
//Разработать приложение, позволяющее просматривать файлы и каталоги файловой
//        системы, а также создавать и удалять текстовые файлы. Для работы с текстовыми файлами
//        необходимо реализовать функциональность записи (дозаписи) в файл. Требуется определить
//        исключения для каждого слоя приложения и корректно их обработать.


import java.io.*;


public class FileCatalog {

    public static void createFile(String dirName, String fileName) {

        File newFile = new File(dirName, fileName);

        try {
            if (newFile.exists()) {
                System.out.println("Файл   с таким именем уже существует");
                System.exit(0);
            }
            boolean isCreated = newFile.createNewFile();
            if (isCreated) {
                System.out.println("файл усешно создан");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteFile(String dirName, String fileName) {
        File file = new File(dirName, fileName);
        if (file.exists()) {
            boolean isDeleted = file.delete();
            if (isDeleted) {
                System.out.println("Файл успешно удалён");
            }
        }else{
            System.out.println("Такого файла не существует");
        }
    }

    public static void getFilesFromDirectory(String dirName) {
        File fileDir = new File(dirName);

        if (fileDir.isDirectory()) {
            for (File file : fileDir.listFiles()) {
                if (file.isDirectory()) {
                    System.out.println(file.getName() + "  \tкаталог");
                } else {
                    System.out.println(file.getName() + "\tфайл");
                }
            }
        }
    }


    public static void writeToFile(String fileName, String data) {
        File tempFile = new File(fileName);
        if (tempFile.exists()) {
            try (BufferedWriter outFile = new BufferedWriter(new FileWriter(tempFile, true))) {
                outFile.write(data + " ");
                System.out.println("Данные добавлены");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Такого файла не существует");
            System.exit(0);
        }
    }

    public static void parseFile(String fileName) {
        String readedString;
        File tempFile = new File(fileName);
        if (tempFile.exists()) {
            try (BufferedReader inFile = new BufferedReader(new FileReader(tempFile))) {
                while ((readedString = inFile.readLine()) != null) {
                    System.out.println(readedString);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
       // C:\Users\Ирина\Desktop\AvdeevaElenaEpam
        FileCatalog.createFile("C:\\Users\\Ирина\\Desktop\\AvdeevaElenaEpam", "createFile.txt");
        FileCatalog.getFilesFromDirectory("C:\\Users\\Ирина\\Desktop\\AvdeevaElenaEpam");
        FileCatalog.writeToFile("createFile","File is Writable");
        FileCatalog.parseFile("createFile.txt");
        FileCatalog.deleteFile("C:\\Users\\Ирина\\Desktop\\AvdeevaElenaEpam", "createFile.txt");
    }


}
