package SE04;


//Дана коллекция фильмов, содержащая информацию об актерах, снимавшихся в
//        главных ролях (один актер мог сниматься и в нескольких фильмах). Необходимо написать
//        приложение, позволяющее при запуске восстанавливать коллекцию фильмов, позволять ее
//        модифицировать, а по завершении работы приложения – сохранять (в файл). Для
//        восстановления/сохранения коллекции использовать сериализацию/десериализацию.
import java.io.*;

public class FilmSerializable implements Serializable {

    public boolean serialization(FilmWithActor film, String filename) throws IOException {
        boolean isSer = false;
        File inFile = new File(filename);
        ObjectOutputStream outstream = null;
        try {
            FileOutputStream fileSteam = new FileOutputStream(inFile);
            if (fileSteam!= null) {
                outstream = new ObjectOutputStream(fileSteam);
                outstream.writeObject(film);
                isSer  = true;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не сoздан");
        } catch (NotSerializableException e) {
            System.out.println( e);
        }
        finally {

                outstream.close();
        }
        return isSer;
    }

    public FilmWithActor deserialization(String fileName) throws InvalidObjectException{
        File dfile = new File(fileName);
        ObjectInputStream instream = null;
        try {
            FileInputStream fis = new FileInputStream(dfile);
            instream = new ObjectInputStream(fis);
            FilmWithActor fl = (FilmWithActor) instream.readObject();
            return fl;
        } catch (ClassNotFoundException ne) {
            System.err.println(ne);
        } catch (IOException ce) {
            System.err.println(ce);
        } finally {
            try {
                if (instream != null) {
                    instream.close();
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        throw new InvalidObjectException("Ошибка дессереалиации объкт не восстановлен");
    }

    public static void main(String[] args) throws IOException {
        String file = "movie.data";

        FilmWithActor happyGays = new FilmWithActor(" Happy Gays", "Nikulin");
        //FilmWithActor titanik = new FilmWithActor("Titanik", "Kate");

        FilmSerializable filmSerializable = new FilmSerializable();
        boolean b = filmSerializable.serialization(happyGays, file);

        FilmWithActor anyFilm = null;
        try {
            anyFilm  = filmSerializable.deserialization(file);
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }
        System.out.println(anyFilm.toString());

    }
}