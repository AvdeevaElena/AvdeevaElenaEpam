package SE07;
import java.util.*;


//Создать “универсальный” класс, позволяющий получить значение из любого properties-
//        файла. Физическое чтение файла должно происходить только один раз. Учтите ситуацию, когда
//        несколько потоков одновременно обращаются к одному и тому же файлу.


public class UniversalProperties extends Thread {

    public boolean isRun;
    public String resource;

    public String keyVal;

    public String localString;
    public Locale locale;

    public ResourceBundle bundle;
    public StringBuilder builder;


    public UniversalProperties(String resource, String localString) {
        isRun = true;
        this.resource = resource;
        this.localString = localString;
    }

    public UniversalProperties(String resource, String localString, String keyVal) {
        isRun = true;
        this.resource = resource;
        this.localString = localString;
        this.keyVal = keyVal;
    }

    public String getProperties() throws MissingResourceException {
        builder = new StringBuilder();
        if (resource == null || localString == null) {
            throw new NullPointerException("Empty data");
        }
        try {
            locale = new Locale(localString);
            bundle = ResourceBundle.getBundle(resource, locale);
            ArrayList<String> keys = new ArrayList<>(Collections.list(bundle.getKeys()));
            for (String value : keys) {
                builder.append(bundle.getString(value)).append("\n");
            }
        } catch (MissingResourceException e) {
            System.out.println("Такой файл не найден");
        }
        return builder.toString();
    }

    public String getPropertyByKey() throws MissingResourceException {
        builder = new StringBuilder();
        if (keyVal == null || localString == null || resource == null) {
            throw new NullPointerException("Отсутствуют значения");
        }
        try {
            locale = new Locale(localString);
            bundle = ResourceBundle.getBundle(resource, locale);
            String getKey = bundle.getString(keyVal);
            builder.append(getKey);
        } catch (MissingResourceException e) {
            System.out.println("Отсутствует ключ");
        }
        return builder.toString();
    }

    public void showResult() {
        if (builder == null) {
            throw new NullPointerException();
        }
        System.out.println(getName() + "\n" + builder);
    }

    public void run() {
        try {
            while (isRun) {
                System.out.println(getName() + "читаем\n");
                Thread.sleep(500);
                getProperties();
                interrupt();
            }
        } catch (InterruptedException e) {
            showResult();
            stopThread();
        }
    }

    public void stopThread() {
        isRun = false;
        System.out.println(getName() + "поток завершил чтение\n");
    }

    public static void main(String[] args) throws InterruptedException {
        UniversalProperties propReader1 = new UniversalProperties("text", "ru_RU");
        UniversalProperties propReader2 = new UniversalProperties("text", "ru_RU");
        UniversalProperties propReader3 = new UniversalProperties("text", "ru_RU");

        System.out.println("Start");
        propReader1.start();
        propReader2.start();
        propReader3.start();

        Thread.sleep(200);

        propReader1.join();
        propReader2.join();
        propReader3.join();

        System.out.println("Finish");
    }
}