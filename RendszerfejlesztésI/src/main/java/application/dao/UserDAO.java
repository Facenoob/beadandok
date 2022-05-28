package application.dao;

import application.model.Film;
import application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
public class UserDAO extends JdbcDaoSupport  {

    @Autowired
    DataSource dataSource;


    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    public void insertUser(User user) {
        String sql = "INSERT INTO users (user_id, first_name,last_name,password,email) VALUES (?,?, ?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[]{
                user.getUserid(),user.getFirst_name(),user.getLast_name(),user.getPassword(),user.getEmail()
        });
    }

    public int canRegister(String email){
        int max=-1;
        String sql = "SELECT * FROM users ";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for(Map<String, Object> row:rows){
            if((Integer) row.get("user_id")>max){
                 max=(Integer) row.get("user_id");
            }
            if(email.equals((String)row.get("email"))) {
                return -1;
            }

        }
        return max+1;

    }
    public boolean canLogin(String email,String password){
        String sql = "SELECT * FROM users ";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for(Map<String, Object> row:rows){
            if(email.equals((String)row.get("email"))&& password.equals((String)row.get("password"))) {
                return true;
            }

        }
        return false;

    }
}
