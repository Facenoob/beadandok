package application.dao;

import application.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ActorDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;


    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public void insertActor(Actor actor){
        String sql = "INSERT INTO actor(actor_id,name,birth_date,image_name VALUES(?,?,?,?)";
        getJdbcTemplate().update(sql, new Object[]{
                actor.getActor_id(),actor.getBirth_date(),actor.getImage_name(),actor.getName()

    });
    }
    public List<Actor> listActor(){
        String sql = "SELECT * FROM actor";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Actor> result =new ArrayList<Actor>();
        for(Map<String,Object>row:rows){
            Actor actor=new Actor();
            actor.setActor_id((Integer)row.get("actor_id"));
            actor.setName((String) row.get("name"));
            actor.setBirth_date((String) row.get("birth_date"));
            actor.setImage_name((String) row.get("image_name"));
            result.add(actor);

        }
        return result;
    }
    public Actor getActorById(int id){
        String sql = "SELECT * FROM  actor_in_movie LEFT JOIN actor ON actor_in_movie.actor_id =actor.actor_id WHERE actor_in_movie.movie_id="+id;
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Actor> result =new ArrayList<Actor>();
        for(Map<String,Object>row:rows){
            Actor actor=new Actor();
            actor.setActor_id((Integer)row.get("actor_id"));
            actor.setName((String) row.get("name"));
            actor.setBirth_date((String) row.get("birth_date"));
            actor.setImage_name((String) row.get("image_name"));
            result.add(actor);

        }
        return result.get(0);
    }
    public void deleteActor(int id){
        String sql = "DELETE FROM actor WHERE actor_id="+id;
        getJdbcTemplate().update(sql);
    }
    public void updateActor(int actor_id,String name,String birth_date,String image_name){
        String sql = "UPDATE film SET Nev='"+name+"', SzuletesNap='"+birth_date+"'Kep='"+image_name+"' WHERE id="+actor_id;
        getJdbcTemplate().update(sql);
    }


}