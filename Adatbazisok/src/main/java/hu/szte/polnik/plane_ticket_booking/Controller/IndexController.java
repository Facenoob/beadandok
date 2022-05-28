package hu.szte.polnik.plane_ticket_booking.Controller;
import hu.szte.polnik.plane_ticket_booking.dao.PlaneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    @Autowired
    private PlaneDAO planeDAO;


//    @PostMapping(value = "/")
//    public String kotel() {
//        String sql1 = "SELECT plane_type FROM  plane INNER JOIN trip ON plane.plane_ID=trip.plane_ID";
//        String sql2 = "SELECT `plane_type` FROM `plane` LEFT JOIN trip ON plane.plane_ID=trip.plane_ID Where trip.destination ="+"'Anglia'"+" GROUP BY plane_type;\n";
//        String sql3 = "SELECT COUNT(user.user_ID), trip.destination FROM user INNER JOIN helptable ON user.user_ID=helptable.user_ID INNER JOIN trip ON helptable.trip_ID=trip.trip_ID GROUP BY trip.destination;\n";
//        String sql4 = "SELECT * FROM trip WHERE cost < (SELECT AVG(cost) FROM trip);";
//        planeDAO.kotelezo(sql1);
//        planeDAO.kotelezo(sql2);
//        planeDAO.kotelezo(sql3);
//        planeDAO.kotelezo(sql4);
//        return "redirect:/";
//    }
    @GetMapping(value = "/")
    public String megkellcsinalni(Model model) {
        String sql1 = "SELECT plane_type FROM  plane INNER JOIN trip ON plane.plane_ID=trip.plane_ID LIMIT 10;";
        model.addAttribute("lekerdezes1", planeDAO.kotelezo(sql1));
        String sql2 = "SELECT `plane_type` FROM `plane` LEFT JOIN trip ON plane.plane_ID=trip.plane_ID Where trip.destination ="+"'Anglia'"+" GROUP BY plane_type LIMIT 10;";
        model.addAttribute("lekerdezes2", planeDAO.kotelezo(sql2));
        String sql3 = "SELECT COUNT(user.user_ID) AS darab, trip.destination AS uticel FROM user INNER JOIN helptable ON user.user_ID=helptable.user_ID INNER JOIN trip ON helptable.trip_ID=trip.trip_ID GROUP BY trip.destination LIMIT 10;";
        model.addAttribute("lekerdezes3", planeDAO.kotelezo(sql3));
        String sql4 = "SELECT * FROM trip WHERE cost < (SELECT AVG(cost) FROM trip) LIMIT 10;";
        model.addAttribute("lekerdezes4", planeDAO.kotelezo(sql4));
        return "index";
    }


}
