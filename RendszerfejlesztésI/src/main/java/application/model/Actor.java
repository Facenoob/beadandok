package application.model;

import java.io.Serializable;


public class Actor implements Serializable{
    private static final long serialVersionUID =1L;

    int actor_id;
    String name;
    String birth_date;
    String image_name;

    public Actor(int actor_id, String name, String birth_date, String image_name) {
        this.actor_id = actor_id;
        this.name = name;
        this.birth_date = birth_date;
        this.image_name = image_name;
    }
    public Actor(){

    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }



}
