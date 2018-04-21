package SE02;


//Используйте “набор новичка”, созданный в задании 3, (или любую другую коллекцию
//        объектов); отсортируйте вещи в этом наборе по стоимости, по наименованию, по стоимости и
//        наименованию.
public class NewPersonSort {
    public NewPersonSort() {
    }

    public static void main(String[] args) {
        Person newMan = new Person();
        NewPersonStaff nPs = new NewPersonStaff();
        newMan.staff = nPs.newpersonstaff;

        for(int i = 0; i <= newMan.staff.length - 1; ++i) {
            System.out.println(newMan.staff[i] + " ");
        }

        System.out.println();
        System.out.println("Sortirovka by Price");
        nPs.sortbyPrice();
        System.out.println("Sortirovka by Name");
        nPs.sortbyName();
    }
}
