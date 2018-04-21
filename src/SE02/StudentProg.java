package SE02;


public class StudentProg {
    //Разработайте приложение, позволяющее формировать группы студентов по разным
//дисциплинам. Состав групп может быть разным. Каждая дисциплина в отдельности определяет,
//целыми или вещественными будут оценки по нет. Необходимо найти группы, в которые входит
//студент X, и сравнить его оценки. Для огранизации перечня дисциплин можно использовать
//перечисление.
    public static void main(String[] args) {

        Group grop_1 =new Group("LOGIC",1);
        CLASSNAME [] logic = {CLASSNAME.MATH, CLASSNAME.IT, CLASSNAME.SQL};
        grop_1.classname = logic;

        Group grop_2 =new Group("LENGUAGES",2);
        CLASSNAME [] lenguages = {CLASSNAME.ENGLISH, CLASSNAME.RUSSIAN, CLASSNAME.SPANISH};
        grop_2.classname = lenguages;

        Group grop_3 =new Group("EATH",3);
        CLASSNAME [] eath = {CLASSNAME.GEOGRAFY, CLASSNAME.BIOLOGY};
        grop_3.classname = eath;


        Student fedor = new Student("Fedor",111);
        Student masha = new Student("Masha",222);




        fedor.setGpoups(grop_3,grop_2);
        masha.setGpoups(grop_1);
        System.out.println("Fedor's groups ");
        fedor.getGpoups();
        System.out.println("Fedor's clasess ");
        fedor.getStudentsClasses();
        System.out.println("Masha's grooups");
        masha.getGpoups();
        System.out.println("Masha's classes");
        masha.getStudentsClasses();
        System.out.println("Gradel Journall");
        masha.studentJournal.setStudendClasees("rus");

        //masha.studentJournal.setClassname(CLASSNAME.ENGLISH);
        // masha.studentJournal.setClassname(CLASSNAME.ENGLISH);
        // masha.studentJournal.setStudendCLASSes(CLASSNAME.ENGLISH);
        String [] aarr = {"rt", "tt"};
        // fedor.studentJournal.setStudendClasees(aarr);

        //  System.out.println(masha.getStudentJournal().studendClasees);
        // masha.studentJournal.setClassname(CLASSNAME.BIOLOGY);
        //masha.studentJournal.getStudendClassees();

    }
}
