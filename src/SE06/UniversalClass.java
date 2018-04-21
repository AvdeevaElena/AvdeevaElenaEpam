package SE06;
//Создать “универсальный” класс, позволяющий получить значение из любого properties-
//        файла. Физическое чтение файла должно происходить только один раз. Результаты чтения
//        храните в коллекции типа Map. Ответьте на вопрос: как ведет себя map-коллекция если в нее
//        добавить элемент с ключом, который уже присутствует?

import java.util.ResourceBundle;
import java.util.*;
public class UniversalClass {

    public String str;
    public static Map<Object, Object> map = new LinkedHashMap<>();
    public static ResourceBundle resBundle;

    public static Map getProp(String fileName) {

        Locale currentLocale = new Locale("ru", "RU");
        resBundle =ResourceBundle.getBundle(fileName,currentLocale);
        Set<String> keys = new HashSet<>(resBundle.keySet());

        for (String id: keys) {
            map.put(keys, resBundle.getObject(id));
        }
        return map;
    }

    public static void main(String[] args) {

        System.out.println(UniversalClass.getProp("text"));


    }
}
