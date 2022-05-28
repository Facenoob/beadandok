package hu.szte.polnik.plane_ticket_booking.dao;

import hu.szte.polnik.plane_ticket_booking.Model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TripDAO extends JdbcDaoSupport {
    @Autowired
    DataSource dataSource;
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    public void insertTrip(Trip trip){
        String sql="INSERT INTO trip (trip_ID,departure_time,leaving_from,destination,cost,pilot,plane_ID,travel_time) VALUES(?,?,?,?,?,?,?,?)";
        getJdbcTemplate().update(sql,new Object[]{
                trip.getTripID(),trip.getDepartureTime(),trip.getLeavingFrom(),trip.getDestination(),trip.getCost(),trip.getPilot(),trip.getPlaneID(),trip.getTravelTime()
        });
    }
    public List<Trip> listTrips(){
        String sql="SELECT * FROM trip";
        List<Trip> result = getTripList(sql);
        return result;
    }
    private List<Trip> getTripList(String sql){
        List<Map<String,Object>> rows= getJdbcTemplate().queryForList(sql);
        List<Trip>result =new ArrayList<>();
        for(Map<String,Object> row :rows){
            Trip trip=new Trip();
            trip.setTripID((Integer) row.get("trip_ID"));
            trip.setDepartureTime((LocalDateTime) row.get("departure_time"));
            trip.setLeavingFrom((String) row.get("leaving_from"));
            trip.setDestination((String) row.get("destination"));
            trip.setCost((Integer) row.get("cost"));
            trip.setPilot((String) row.get("pilot"));
            trip.setPlaneID((Integer) row.get("plane_ID"));
            trip.setTravelTime((Time) row.get("travel_time"));
            result.add(trip);
        }
        return result;
    }
    public Trip getTripByID(int id){
        String sql = "SELECT * FROM trip WHERE trip_ID="+id;
        List<Trip> result = getTripList(sql);
        return result.get(0);
    }
    public void deleteTrip(int id){
        String sql = "DELETE FROM trip WHERE trip_ID="+id;
        getJdbcTemplate().update(sql);
    }
    public void updateTrip(int trip_ID, LocalDateTime departure_time, String leaving_from, String destination, int cost, String pilot, int plane_ID , Time travel_time){
        String sql= "UPDATE trip SET departure_time='"+departure_time+"', leaving_from='"+leaving_from+"', destination='"+destination+"', cost='"+cost+"', pilot='"+pilot+"', plane_ID='"+plane_ID+"', travel_time='"+travel_time+"' WHERE trip_ID="+trip_ID;
        getJdbcTemplate().update(sql);
    }
    public int canRegister(String destination) {
        int max = -1;
        String sql = "SELECT * FROM trip ";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map<String, Object> row : rows) {
            if ((Integer) row.get("trip_ID") > max) {
                max = (Integer) row.get("trip_ID");
            }
            if (destination.equals((String) row.get("destination"))) {
                return -1;
            }

        }
        return max + 1;

    }
}
