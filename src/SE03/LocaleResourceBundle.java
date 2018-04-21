package SE03;

//Разработать приложение, позволяющее по выбору пользователя использовать
//        русский или английский язык, для отображения информации. Приложение должно
//        представлять собой перечень вопросов под номерами (на английском или русском
//        соответственно). Выбрав номер вопроса пользователь может узнать ответ на него.


import java.util.ResourceBundle;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Scanner;

public class LocaleResourceBundle {

    private static ResourceBundle rb;
    public static String getPropByKey(String key) throws UnsupportedEncodingException {
        return new String(rb.getString(key).getBytes("ISO-8859-1"), "UTF-8");
    }
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        Locale currentLocale =null;
        try {
            System.out.println("ru - 1 / en - 2");
            String locale;
            int n;

            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            if (n == 1) {
                currentLocale = new Locale("RU", "ru");
            } else {
                if (n == 2) {
                    currentLocale = new Locale("EN", "UK");
                } else {
                    System.exit(0);
                }
            }
            rb = ResourceBundle.getBundle("text",currentLocale);
            System.out.println ("in Bundle1" +
                            " ");
            System.out.println("1: " + getPropByKey("way1.q1"));
            System.out.println("2: " + getPropByKey("way1.q2"));
            System.out.println("1 / 2");
            if ("1".equals(scann.nextLine())) {
                System.out.println(getPropByKey("way1.ans1"));
            } else {
                System.out.println(getPropByKey("way1.ans2"));
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("Не поддерживается кондировка");
        } finally {
            scann.close();
        }
    }


}
