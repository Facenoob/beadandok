package hu.szte.polnik.plane_ticket_booking.dao;

import hu.szte.polnik.plane_ticket_booking.Model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class PlaneDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    public void insertPlane(Plane plane) {
        String sql = "INSERT INTO plane (plane_ID,plane_type, max_capacity) VALUES (?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[]{
                plane.getPlane_ID(),plane.getPlane_type(),plane.getMax_capacity()
        });
    }
    
    public List<Plane> listPlanes(){
        String sql="SELECT * FROM plane";
        List<Plane> result = getPlaneList(sql);
        return result;
    }

    private List<Plane> getPlaneList(String sql) {
        List<Map<String,Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Plane> result =new ArrayList<>();
        for(Map<String,Object> row : rows){
            Plane plane= new Plane();
            plane.setPlane_ID((Integer) row.get("plane_ID"));
            plane.setPlane_type((String) row.get("plane_type"));
            plane.setMax_capacity((Integer) row.get("max_capacity"));
            result.add(plane);
        }
        return result;
    }

    public Plane getPlaneByID(int id) {
        String sql = "SELECT * FROM plane WHERE plane_id="+id;
        List<Plane> result = getPlaneList(sql);
        return result.get(0);
    }

    public void deletePlane(int id){
        String sql = "DELETE FROM plane WHERE plane_ID="+id;
        getJdbcTemplate().update(sql);
    }

    public void updatePlane(int plane_id,String plane_type,int max_capacity){
        String sql= "UPDATE plane SET plane_type='"+plane_type+"', max_capacity='"+max_capacity+"' WHERE plane_id="+plane_id;
        getJdbcTemplate().update(sql);
    }
    public int canRegister(String planetype) {
        int max = -1;
        String sql = "SELECT * FROM plane ";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map<String, Object> row : rows) {
            if ((Integer) row.get("plane_ID") > max) {
                max = (Integer) row.get("plane_ID");
            }
            if (planetype.equals((String) row.get("palne_type"))) {
                return -1;
            }

        }
        return max + 1;

    }
    public List<Map<String, Object>>  kotelezo(String sql) {
        List<Map<String, Object>> row = getJdbcTemplate().queryForList(sql);
        return row;


    }

}
