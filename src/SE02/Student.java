
package SE02;

import java.io.PrintStream;

public class Student {
    String name;
    int id;
    Group[] gpoups;
    StudentJournal[] classAndMark;
    Group gpoup;
    StudentJournal studentJournal;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setStudentJournal(StudentJournal classType) {
        this.studentJournal = classType;
    }

    public StudentJournal getStudentJournal() {
        return this.studentJournal;
    }

    public void setGpoup(Group gpoup) {
        this.gpoup = gpoup;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGpoups(Group... gpoup) {
        this.gpoups = gpoup;

        for(int i = 0; i < this.gpoups.length; ++i) {
            for(int y = 0; y < this.gpoups[i].classname.length; ++y) {
                PrintStream var10000 = System.out;
                String var10001 = this.gpoups[i].classname[y].toString();
                var10000.print(var10001 + " ");
            }
        }

    }

    public void getGpoups() {
        for(int i = 0; i < this.gpoups.length; ++i) {
            System.out.print(this.gpoups[i].groupName + " ");
        }

    }

    public void getStudentsClasses() {
        for(int i = 0; i < this.gpoups.length; ++i) {
            for(int y = 0; y < this.gpoups[i].classname.length; ++y) {
                PrintStream var10000 = System.out;
                String var10001 = this.gpoups[i].classname[y].toString();
                var10000.print(var10001 + " ");
            }
        }

    }

    public void setMarkorGrade(StudentJournal classType) {
    }

    public void setClassAndMark(StudentJournal[] classAndMark) {
        this.classAndMark = classAndMark;
    }

    public StudentJournal[] getClassAndMark() {
        return this.classAndMark;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }
}