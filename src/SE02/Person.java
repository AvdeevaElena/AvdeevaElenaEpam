package SE02;


public class Person {
    String name;
    Staff[] staff;

    Person() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setStaff(Staff[] staff) {
        this.staff = staff;
    }

    public Staff[] getStaff() {
        return this.staff;
    }

    public double getBalance() {
        double sum = 0.0D;

        for(int i = 0; i <= this.staff.length - 1; ++i) {
            sum += this.staff[i].price;
        }

        return sum;
    }
}