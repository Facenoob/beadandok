package hu.szte.polnik.plane_ticket_booking.dao;

import hu.szte.polnik.plane_ticket_booking.Model.Plane;
import hu.szte.polnik.plane_ticket_booking.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.transaction.Transaction;
import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;


    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public void insertUser(User user) {
        String sql = "INSERT INTO user (user_ID,first_name,last_name,citizenship,mobile,password,`e-mail`) VALUES (?,?, ?, ?, ?,?,?)";
        getJdbcTemplate().update(sql, new Object[]{
                user.getUserid(), user.getFirst_name(), user.getLast_name(), user.getCitizenship(), user.getMobile(), user.getPassword(), user.getEmail()
        });
    }

    public int canRegister(String email) {
        int max = -1;
        String sql = "SELECT * FROM user ";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map<String, Object> row : rows) {
            if ((Integer) row.get("user_id") > max) {
                max = (Integer) row.get("user_id");
            }
            if (email.equals((String) row.get("email"))) {
                return -1;
            }

        }
        return max + 1;

    }

    public boolean canLogin(String email, String password) {
        String sql = "SELECT * FROM user ";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map<String, Object> row : rows) {
            if (email.equals((String) row.get("email")) && password.equals((String) row.get("password"))) {
                return true;
            }

        }
        return false;

    }

    public List<User> listUsers() {
        String sql = "SELECT * FROM user";
        return getUserList(sql);
    }

    private List<User> getUserList(String sql) {
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<User> result = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            User user = new User();
            user.setUserid((Integer) row.get("user_ID"));
            user.setFirst_name((String) row.get("first_name"));
            user.setLast_name((String) row.get("last_name"));
            user.setCitizenship((String) row.get("citizenship"));
            user.setMobile((String) row.get("mobile"));
            user.setEmail((String) row.get("e-mail"));
            user.setPassword((String) row.get("password"));
            result.add(user);
        }
        return result;
    }

    public void deletUser(int id){
        String sql = "DELETE FROM user WHERE user_ID="+id;
        getJdbcTemplate().update(sql);
    }
    public void updateUser(int user_id ,String first_name ,String last_name ,String citizenship,String mobil,String mail,String password){
        String sql = "UPDATE user SET user.first_name='"+first_name+"', user.last_name='"+last_name+"',user.citizenship='"+citizenship+"',user.mobile='"+mobil+"',user.`e-mail`='"+mail+"',user.password='"+password+"' WHERE user.user_ID="+user_id;
        getJdbcTemplate().update(sql);
    }
    public User getUserByID(int id) {
        String sql = "SELECT * FROM user WHERE user_ID="+id;
        List<User> result = getUserList(sql);
        return result.get(0);
    }


}

