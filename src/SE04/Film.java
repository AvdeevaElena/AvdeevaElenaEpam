package SE04;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.io.*;


public class Film implements Serializable {
    public void filmCreator(Object films) {
        PrintWriter pw = null;
        File file = new File("movie.txt");
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            pw.print(films);
            pw.flush();
        } catch (IOException e) {
            System.out.println("Не удалось записать фильмы");
        }finally{
            pw.close();
        }
    }
}