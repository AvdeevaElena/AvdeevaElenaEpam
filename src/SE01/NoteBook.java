package SE01;



public class NoteBook {
    private static final int Note_SIZE = 5;
    private String[] records = new String[5];
    private int last = 0;

    public NoteBook() {
    }

    public void add(String record) {
        if (this.last > this.records.length) {
            throw new UnsupportedOperationException("UnsupportedOperationException");
        } else {
            this.records[this.last++] = record;
        }
    }

    public void delete(int position) {
        System.arraycopy(this.records, position + 1, this.records, position, this.last - position);
        --this.last;
    }

    public static void main(String[] args) {
        NoteBook myNoteBook = new NoteBook();
        myNoteBook.add("java spring 10");
        myNoteBook.add("11");

        int i;
        for(i = 0; i < myNoteBook.records.length; ++i) {
            System.out.println(myNoteBook.records[i]);
        }

        myNoteBook.delete(1);

        for(i = 0; i < myNoteBook.records.length; ++i) {
            System.out.println(myNoteBook.records[i]);
        }

    }
}
