package application.model;

import java.io.Serializable;

public class Film implements Serializable{
	
    private static final long serialVersionUID = 1L;

    int movie_id;
    String title;
    int release;
    int age_restriction;
    String director;
    int game_time;
    double rate;
    String image;

    public Film(int movie_id, String title, int release, int age_restriction, String director, int game_time, double rate,String image) {
        this.movie_id = movie_id;
        this.title = title;
        this.release = release;
        this.age_restriction = age_restriction;
        this.director = director;
        this.game_time = game_time;
        this.rate = rate;
        this.image= image;
    }

    public Film(){

    }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    public int getAge_restriction() {
        return age_restriction;
    }

    public void setAge_restriction(int age_restriction) {
        this.age_restriction = age_restriction;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getGame_time() {
        return game_time;
    }

    public void setGame_time(int game_time) {
        this.game_time = game_time;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }



}
