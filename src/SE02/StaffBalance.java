

package SE02;

//Напишите приложение, позволяющее вести учет канцелярских товаров на рабочем месте
//        сотрудника. Определите полную стоимость канцтоваров у определенного сотрудника

public class StaffBalance {
    public StaffBalance() {
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Rita";
        Person person_2 = new Person();
        person_2.name = "Djeck";
        Staff pen1 = new Pen();
        pen1.price = 20.88D;
        Pen pen2 = new Pen();
        pen2.price = 30.9D;
        Pensell pensell_1 = new Pensell();
        pensell_1.price = 10.0D;
        Pensell pensell_2 = new Pensell();
        pensell_2.price = 10.01D;
        Staff[] order1 = new Staff[]{pen2, pen1, pensell_1, pensell_2};
        person.staff = order1;
        System.out.println(person.getBalance());
        Staff[] order_2 = new Staff[]{pen2, pensell_2};
        person_2.staff = order_2;
        System.out.println(person_2.getBalance());
    }
}

