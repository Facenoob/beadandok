package hu.szte.polnik.plane_ticket_booking.Model;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;

public class Trip implements Serializable {
    int tripID;
    LocalDateTime departureTime;
    String leavingFrom;
    String destination;
    int cost;
    String pilot;
    int planeID;
    Time travelTime;

    public Trip() {
    }

    public Trip(int tripID, LocalDateTime departureTime, String leavingFrom, String destination, int cost, String pilot, int planeID, Time travelTime) {
        this.tripID = tripID;
        this.departureTime = departureTime;
        this.leavingFrom = leavingFrom;
        this.destination = destination;
        this.cost = cost;
        this.pilot = pilot;
        this.planeID = planeID;
        this.travelTime = travelTime;
    }

    public int getTripID() {
        return tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getLeavingFrom() {
        return leavingFrom;
    }

    public void setLeavingFrom(String leavingFrom) {
        this.leavingFrom = leavingFrom;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getPilot() {
        return pilot;
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }

    public int getPlaneID() {
        return planeID;
    }

    public void setPlaneID(int planeID) {
        this.planeID = planeID;
    }

    public Time getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Time travelTime) {
        this.travelTime = travelTime;
    }
}
