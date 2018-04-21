package SE04;

import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

public class FileParse {
    private static Map<String, Integer> resultMap;

    private static String[] inWorlds;
    private static String[] inFile;

    private static byte[] byteWordFile;
    private static byte[] byteFile;

    private static String resInString;
    private static String fileString;


    FileParse() {
        resultMap = new HashMap<>();
    }


    public Map wordsCount(String reservedJavaWordsFileName, String outputFileName, String javaFileName) {
        try (OutputStream infoStoreFileAboutJavaFile = new FileOutputStream(outputFileName);
             InputStream reservedJavaWordsFile = new FileInputStream(reservedJavaWordsFileName);
             InputStream javaFile = new FileInputStream(javaFileName)) {

            byteWordFile = new byte[reservedJavaWordsFile.available()];
            byteFile = new byte[javaFile.available()];

            reservedJavaWordsFile.read(byteWordFile, 0,byteWordFile.length);
            javaFile.read(byteFile, 0, byteFile.length);

// retrieve arrays of bytes from files - with java keywords and with .java program file byte[]->String->String[] via split()
            resInString = new String(byteWordFile, StandardCharsets.UTF_8);
            inWorlds = resInString.split("\\n");

            fileString = new String(byteFile, StandardCharsets.UTF_8);
            inFile = fileString.split("\\s+|\\n+|\\t+|^[a-zA-Z]|^[0-9]");

            for (int javaReservedWordsArrayCounter = 0;
                 javaReservedWordsArrayCounter < inWorlds.length; javaReservedWordsArrayCounter++) {
                int    mapCounter = 0;
                String tmpStr     = inWorlds[javaReservedWordsArrayCounter];
                for (int javaFileCounter = 0; javaFileCounter <inFile.length; javaFileCounter++) {
                    if (tmpStr.equals(inFile[javaFileCounter])) {
                        resultMap.put(tmpStr, ++mapCounter);
                    }
                }
            }
            String[] resultStringAr        = new String[resultMap.size()];
            int      resultStringArCounter = 0;
            for (Map.Entry entry :
                    resultMap.entrySet()) {
                resultStringAr[resultStringArCounter] =
                        "Ключевое слово Java - " + entry.getKey() + " повторяется в файле " + outputFileName + " " +
                                entry.getValue() + " раз;" + "\\n";
            }

            StringBuilder resultStringBuilder = new StringBuilder();
            for (resultStringArCounter = 0; resultStringArCounter < resultStringAr.length;
                 resultStringArCounter++) {
                resultStringBuilder.append(resultStringAr[resultStringArCounter]);
            }

            char[] resultCharAr = (new String(resultStringBuilder.toString())).toCharArray();
            byte[] resultByteAr = new byte[resultCharAr.length];

            for (int resultByteCounter = 0; resultByteCounter < resultByteAr.length; resultByteCounter++) {
                resultByteAr[resultByteCounter] = (byte) resultCharAr[resultByteCounter];
            }

            infoStoreFileAboutJavaFile.write(resultByteAr, 0, resultByteAr.length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultMap;
    }



}
