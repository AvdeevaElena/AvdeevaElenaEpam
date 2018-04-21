

package SE02;

//Разработайте иерархию канцелярских товаров. Создайте “набор новичка”, используя
//        созданную иерархию.


public class NewPersonStaff {
    Pen pen = new Pen();
    Pensell pensell = new Pensell();
    Liner liner = new Liner();
    Staff[] newpersonstaff;

    NewPersonStaff() {
        this.newpersonstaff = new Staff[]{this.pen, this.pensell, this.liner};
        this.pen.color = COLOR.BLUE;
        this.pen.type = "gel";
        this.pen.price = 2.0D;
        this.pen.articul = 111;
        this.pen.name = "ABC";
        this.pensell.color = COLOR.GREEN;
        this.pensell.price = 1.0D;
        this.pensell.name = "BIG";
        this.liner.color = COLOR.RED;
        this.liner.price = 2.0D;
        this.liner.size = 15;
        this.liner.name = "ZIPPO";
    }

    public void sortbyPrice() {
        NewPersonStaff free = new NewPersonStaff();

        int i;
        for(i = 0; i <= this.newpersonstaff.length - 1; ++i) {
            for(int y = i + 1; y <= this.newpersonstaff.length - 1; ++y) {
                if (this.newpersonstaff[i].price <= this.newpersonstaff[y].price) {
                    free.newpersonstaff[i] = this.newpersonstaff[i];
                    this.newpersonstaff[i] = this.newpersonstaff[y];
                    this.newpersonstaff[y] = free.newpersonstaff[i];
                }
            }
        }

        for(i = 0; i <= this.newpersonstaff.length - 1; ++i) {
            System.out.println(this.newpersonstaff[i] + " ");
        }

    }

    public void sortbyName() {
        NewPersonStaff free = new NewPersonStaff();

        int i;
        for(i = 0; i <= this.newpersonstaff.length - 1; ++i) {
            for(int y = i + 1; y <= this.newpersonstaff.length - 1; ++y) {
                if (this.newpersonstaff[i].name.charAt(0) >= this.newpersonstaff[y].name.charAt(0)) {
                    free.newpersonstaff[i] = this.newpersonstaff[i];
                    this.newpersonstaff[i] = this.newpersonstaff[y];
                    this.newpersonstaff[y] = free.newpersonstaff[i];
                }
            }
        }

        for(i = 0; i <= this.newpersonstaff.length - 1; ++i) {
            System.out.println(this.newpersonstaff[i] + " ");
        }

    }

    public static void main(String[] args) {
        Person newMan = new Person();
        NewPersonStaff nPs = new NewPersonStaff();
        newMan.staff = nPs.newpersonstaff;

        for(int i = 0; i <= newMan.staff.length - 1; ++i) {
            System.out.println(newMan.staff[i] + " ");
        }

        System.out.println();
    }
}
