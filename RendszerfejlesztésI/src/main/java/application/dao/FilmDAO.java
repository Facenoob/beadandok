package application.dao;

import application.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
public class FilmDAO extends JdbcDaoSupport  {
	
	@Autowired 
	DataSource dataSource;


	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public void insertFilm(Film film) {
		String sql = "INSERT INTO film (movie_id, title, release, age_restriction, director, game_time, rate VALUES (?, ?, ?, ?, ?, ?, ?)";
		getJdbcTemplate().update(sql, new Object[]{
				film.getMovie_id(),film.getTitle(),film.getRelease(),film.getAge_restriction(), film.getRate(), film.getGame_time()
		});
	}

	public List<Film> listFilms(){
		String sql = "SELECT * FROM film";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

		List<Film> result = new ArrayList<Film>();
		for(Map<String, Object> row:rows){
			Film film = new Film();
			film.setMovie_id((Integer)row.get("movie_id"));
			film.setTitle((String)row.get("title"));
			film.setRate((Double)row.get("rate"));
			film.setRelease((Integer) row.get("release"));
			film.setGame_time((Integer) row.get("game_time"));
			film.setAge_restriction((Integer)row.get("age_restriction"));
			film.setDirector((String)row.get("director"));
			film.setImage((String)row.get("image"));
			result.add(film);
		}
		
		return result;
	}
	
	public Film getFilmById(int id){
		String sql = "SELECT * FROM film WHERE movie_id="+id;
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Film> result = new ArrayList<Film>();
		for(Map<String, Object> row:rows){
			Film film = new Film();
			film.setMovie_id((Integer)row.get("movie_id"));
			film.setTitle((String)row.get("title"));
			film.setRate((Double) row.get("rate"));
			film.setRelease((Integer) row.get("release"));
			film.setGame_time((Integer) row.get("game_time"));
			film.setAge_restriction((Integer)row.get("age_restriction"));
			film.setDirector((String)row.get("director"));
			result.add(film);
		}
		
		return result.get(0);
	}
	
	public void deleteFilm(int id){
		String sql = "DELETE FROM film WHERE movie_id="+id;
		getJdbcTemplate().update(sql);	
	}
	
	public void updateFilm(int movie_id ,String title ,int release ,int  age_restriction,String director,int game_time,float rate){
		String sql = "UPDATE film SET filmCim='"+title+"', kiadasEve='"+release+"'Pontszam='"+rate+"',jatekIdo='"+game_time+"',Korhatar='"+age_restriction+"' WHERE id="+movie_id;
		getJdbcTemplate().update(sql);	
	}


	}