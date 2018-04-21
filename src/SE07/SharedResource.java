package SE07;
import java.util.ArrayList;
import java.util.List;

//Перепишите код приложения для темы Wait, notify так, чтобы ситуация, когда все потоки хотят
//        прочитать из очереди, не могла возникнуть.


    public class SharedResource {
        private List<Integer> list;

        public SharedResource() {
            list = new ArrayList<>();
        }

        public void setElement(Integer element) {
            list.add(element);
        }

        public List<Integer> getList() {
            return list;
        }

        public Integer getElement() {
            if (list.size() > 0) {
                return list.remove(0);
            }
            return null;
        }
    }