package SE02;


import java.lang.annotation.*;

//Разработайте класс АтомнаяЛодка, создайте внутренний класс –
//        ДвигательДляАтомнойЛодки. Создайте объект АтомнаяЛодка и “запустите его в плавание”.

public class AtomBoat {
    String name;
    int id;


    AtomBoat(String name, int id) {
        this.id = id;
        this.name = name;
    }

    class Motor {
        int id_motor;
        public void takeWay() {
            System.out.println("R-R-R");
        }
    }



    public static void main(String[] args) {
        AtomBoat brigandina = new AtomBoat("Brigandina", 111);

        AtomBoat.Motor motor_1 = brigandina.new Motor();
        motor_1.takeWay();
    }

}