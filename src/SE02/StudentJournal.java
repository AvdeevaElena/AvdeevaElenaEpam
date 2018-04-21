

package SE02;

public class StudentJournal {
    CLASSNAME classname;
    int mark;
    GRADE grade;
    String[] studendClasees;
    CLASSNAME[] studendCLASSes;

    StudentJournal() {
    }

    StudentJournal(String[] studendClasees) {
        this.studendClasees = studendClasees;
    }

    StudentJournal(CLASSNAME[] studendCLASSes) {
        this.studendCLASSes = studendCLASSes;
    }

    StudentJournal(CLASSNAME classname) {
        this.classname = classname;
    }

    public void setStudendCLASSes(CLASSNAME... studendCLASSes) {
        this.studendCLASSes = studendCLASSes;
    }

    public void setStudendClasees(String... studendClasees) {
        this.studendClasees = studendClasees;
    }

    public CLASSNAME[] getStudendCLASSes() {
        return this.studendCLASSes;
    }

    public void getStudendClassees() {
        for(int i = 0; i < this.studendCLASSes.length; ++i) {
            CLASSNAME var10001 = this.studendCLASSes[i];
            System.out.print(var10001.toString() + " ");
        }

    }

    public void getStudendClasees() {
        for(int i = 0; i < this.studendClasees.length; ++i) {
            String var10001 = this.studendClasees[i];
            System.out.print(var10001.toString() + " ");
        }

    }

    public void setClassname(CLASSNAME classname) {
        this.classname = classname;
    }

    public void setGrade(GRADE grade) {
        this.grade = grade;
    }

    public void setMark(int mark) {
    }

    public CLASSNAME getClassname() {
        return this.classname;
    }

    public int getMark() {
        return this.mark;
    }

    public GRADE getGrade() {
        return this.grade;
    }

    StudentJournal(CLASSNAME classname, int mark) {
        this.classname = classname;
        this.mark = mark;
    }

    StudentJournal(CLASSNAME classname, GRADE grade) {
        this.classname = classname;
        this.grade = grade;
    }
}
