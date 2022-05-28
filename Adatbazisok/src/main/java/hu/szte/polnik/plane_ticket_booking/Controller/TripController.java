package hu.szte.polnik.plane_ticket_booking.Controller;

import hu.szte.polnik.plane_ticket_booking.Model.Plane;
import hu.szte.polnik.plane_ticket_booking.Model.Trip;
import hu.szte.polnik.plane_ticket_booking.dao.TripDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Time;
import java.time.LocalDateTime;

@Controller
public class TripController {

    @Autowired
    private TripDAO tripDAO;

    @PostMapping(value = "/tripregister")
    public String registerCheck(@RequestParam("departure_time")LocalDateTime departure_time, @RequestParam("leaving_from")String leaving_from, @RequestParam("destination")String  destination, @RequestParam("cost")int cost , @RequestParam("pilot")String pilot, @RequestParam("plane_ID") int plane_ID, @RequestParam("travel_time") Time travel_time){
        int tripID= tripDAO.canRegister(destination);
        if(tripID==-1){return "redirect:tripregister"; }
        Trip trip=new Trip(tripID,departure_time,leaving_from,destination,cost,pilot,plane_ID,travel_time);
        tripDAO.insertTrip(trip);
        return "redirect:/tripregister";
    }
    @GetMapping(value = "/tripregister")
    public String listPlane(Model model) {
        model.addAttribute("trips", tripDAO.listTrips());
        return "tripreg";
    }
    @GetMapping("/tripedelete")
    public String deleteTrip(@RequestParam("id") int id) {
        tripDAO.deleteTrip(id);
        return "redirect:/tripregister";
    }
    @GetMapping("/showTripUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("tripupdate");
        Trip trip = tripDAO.getTripByID(id);
        mav.addObject("trip", trip);
        return mav;
    }
    @PostMapping("/saveTrip")
    public String saveTrip(@ModelAttribute Trip trip) {
        tripDAO.updateTrip(trip.getTripID(), trip.getDepartureTime(), trip.getLeavingFrom(),trip.getDestination(),trip.getCost(),trip.getPilot(),trip.getPlaneID(),trip.getTravelTime());
        return "redirect:/tripregister";
    }
    @PostMapping("/tripupdate/{id}")
    public String updateTrip(@RequestParam("trip_ID") int tripID, @RequestParam("departure_time") LocalDateTime departure_time, @RequestParam("leaving_from")String leaving_from, @RequestParam("destination")String  destination, @RequestParam("cost")int cost , @RequestParam("pilot")String pilot, @RequestParam("plane_ID") int plane_ID, @RequestParam("travel_time") Time travel_time)
    {
        tripDAO.updateTrip(tripID,departure_time,leaving_from,destination,cost,pilot,plane_ID,travel_time );

        return "redirect:/tripregister";
    }


}
