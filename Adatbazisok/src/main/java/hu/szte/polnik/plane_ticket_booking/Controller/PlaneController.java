package hu.szte.polnik.plane_ticket_booking.Controller;

import hu.szte.polnik.plane_ticket_booking.Model.Plane;
import hu.szte.polnik.plane_ticket_booking.dao.PlaneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlaneController {

    @Autowired
    private PlaneDAO planeDAO;


    @PostMapping(value = "/planeregister")
    public String registerCheck(@RequestParam("plane_type") String planeType, @RequestParam("max_capacity") int maxCapacity) {
        int planeId= planeDAO.canRegister(planeType);
        if(planeId==-1){return "redirect:planeregister"; }
        Plane plane = new Plane(planeId, planeType, maxCapacity);
        planeDAO.insertPlane(plane);

        return "redirect:/planeregister";
    }

    @GetMapping(value = "/planeregister")
    public String listPlane(Model model) {
        model.addAttribute("planes", planeDAO.listPlanes());
        return "planereg";
    }

    @GetMapping("/planedelete")
    public String deletePlane(@RequestParam("id") int id) {
        planeDAO.deletePlane(id);
        return "redirect:/planeregister";
    }

    @GetMapping("/showplaneUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam int planeid) {
        ModelAndView mav = new ModelAndView("planeupdate");
        Plane plane = planeDAO.getPlaneByID(planeid);
        mav.addObject("plane", plane);
        return mav;
    }

    @PostMapping("/savePlane")
    public String savePlane(@ModelAttribute Plane plane) {
        planeDAO.updatePlane(plane.getPlane_ID(), plane.getPlane_type(), plane.getMax_capacity());
        return "redirect:/planeregister";
    }
    @PostMapping("/planeupdate/{id}")
    public String updatePlane(@RequestParam("plane_ID") int planeId, @RequestParam("plane_type") String planeType, @RequestParam("max_capacity") int maxCapacity)
    {
        planeDAO.updatePlane(planeId ,planeType ,maxCapacity );

        return "redirect:/planeregister";
    }

}

