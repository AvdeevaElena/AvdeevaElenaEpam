package SE04;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

import java.io.IOException;
import  java.util.ArrayList;

public class JavaCharReads {

    static String outFile;


    public static void countKeywordsAndWriteToCharFile(String fileToCountPath, String outputFilePath) throws IOException {

        String fileContent = new String(getCharFromFile(fileToCountPath));
        stringToFile(KeyWords.countJavaKeywords(fileContent).toString(), outputFilePath);
    }

    private static char[] getCharFromFile(String filePath) throws IOException {
        char[] charArr;
        File f = new File(filePath);
        try (FileReader fileReader = new FileReader(f)) {
            charArr = new char[(int) f.length()];
            fileReader.read(charArr, 0, charArr.length);
        }
        return charArr;
    }

    private static void stringToFile(String strIn, String fileName) {
        char[] charArr = strIn.toCharArray();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(charArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {

        String inFile = "javaSetWordsChar.txt";
        String outFile = "javaAnswerChar.txt";
        try {
            JavaCharReads.countKeywordsAndWriteToCharFile(inFile,outFile);

        }
        catch(IOException e)  {
            e.printStackTrace();
        } ;

        System.out.println( "Проверяй javaAnswerChar.txt");


    }
}
