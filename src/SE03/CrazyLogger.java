package SE03;

//Необходимо создать класс CrazyLogger, ведущий журнал лога, используя как
//        накопитель объект типа StringBuilder. Логгер должен содержать методы поиска
//        определенной информации в таком логе [с возможностью вывода ее в поток ввода вывода].
//        Информацию логгер хранит в форматированном виде: dd-mm-YYYY : hh-mm – message;.

import java.text.SimpleDateFormat;
import java.util.Date;

public class CrazyLogger {

    private static final int NOT_VALID_INDEX = -1;

    private static final String END_OF_MESSAGE = ";\n";
    private static final SimpleDateFormat format = new SimpleDateFormat("dd-mm-YYYY : hh-mm - ");

    private StringBuilder crazySB = new StringBuilder();

    public CrazyLogger() {
    }

    public void log(String message) {
        crazySB.append(format.format(new Date()));
        crazySB.append(message);
        crazySB.append(END_OF_MESSAGE);
    }

    public String find(String query) {
        StringBuilder sb = new StringBuilder();

        int index = crazySB.indexOf(query);
        while (valid(index)) {
            sb.append(getLog(index));
            index = crazySB.indexOf(query, index + 1);
        }
        return sb.toString();
    }

    private String getLog(int index) {

        int possibleStart = crazySB.lastIndexOf(END_OF_MESSAGE, index);
        int start = valid(possibleStart) ? possibleStart + END_OF_MESSAGE.length() : 0;

        int end = crazySB.indexOf(END_OF_MESSAGE, index) + END_OF_MESSAGE.length();

        return crazySB.subSequence(start, end).toString();

    }

    private static boolean valid(int index) {
        return index != NOT_VALID_INDEX;
    }

    @Override
    public String toString() {
        return crazySB.toString();
    }
}