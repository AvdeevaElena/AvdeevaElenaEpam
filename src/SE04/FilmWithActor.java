package SE04;

import java.io.Serializable;

public class FilmWithActor implements Serializable {

    private static final int serialVersiov = 1;


    private String film;
    private String actor;

    public FilmWithActor(String film, String actor) {

        this.film = film;
        this.actor = actor;
    }

    public String getActor() {
        return actor;
    }

    public String getFilm() {
        return film;
    }

    public String toString(){
        return (film +" "+ actor);
    }
}