package hu.szte.polnik.plane_ticket_booking.Model;


import java.io.Serializable;

public class Plane implements Serializable {
    private Integer plane_ID;

    private String plane_type;
    private Integer max_capacity;

    public Plane(Integer plane_ID, String plane_type, Integer max_capacity) {
        this.plane_ID = plane_ID;
        this.plane_type = plane_type;
        this.max_capacity = max_capacity;
    }

    public Plane() {
    }

    public Integer getPlane_ID() {
        return plane_ID;
    }

    public void setPlane_ID(Integer plane_ID) {
        this.plane_ID = plane_ID;
    }

    public String getPlane_type() {
        return plane_type;
    }

    public void setPlane_type(String plane_type) {
        this.plane_type = plane_type;
    }

    public Integer getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(Integer max_capacity) {
        this.max_capacity = max_capacity;
    }
}
