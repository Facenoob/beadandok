package hu.szte.polnik.plane_ticket_booking.Controller;

import hu.szte.polnik.plane_ticket_booking.Model.User;
import hu.szte.polnik.plane_ticket_booking.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;


    @PostMapping(value = "/register")
    public String registerCheck(@RequestParam("firstname") String first_name, @RequestParam("lastname") String last_name,@RequestParam("citizenship") String citizenship,@RequestParam("mobile") String mobile, @RequestParam("password") String password,@RequestParam("email") String email)
    {
        int userid= userDAO.canRegister(email);
        if(userid==-1){return "redirect:register"; }
        User user = new User(userid,first_name,last_name,citizenship, mobile, password,email);
        userDAO.insertUser(user);

        return "redirect:/register";
    }
    @GetMapping(value = "/register")
    public String listUsers(Model model) {
        model.addAttribute("users", userDAO.listUsers());
        return "reg";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }


    @PostMapping(value = "/login")
    public String loginCheck( @RequestParam("password") String password,@RequestParam("email") String email)
    {
        if(userDAO.canLogin(email,password)){

            return "redirect:/";
        }

        return "redirect:/login";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
       userDAO.deletUser(id);
       return "redirect:/register";
    }
    @PostMapping("/update/{id}")
    public String updateUser(@RequestParam("id") int id, @RequestParam("firstname") String first_name, @RequestParam("lastname") String last_name,@RequestParam("citizenship") String citizenship,@RequestParam("mobile") String mobile, @RequestParam("password") String password,@RequestParam("email") String email)
    {
        userDAO.updateUser(id ,first_name ,last_name ,citizenship,mobile,email,password);

        return "redirect:/register";
    }
    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam int userid) {
        ModelAndView mav = new ModelAndView("update");
        User user = userDAO.getUserByID(userid);
        mav.addObject("user", user);
        return mav;
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user) {
        userDAO.updateUser(user.getUserid() ,user.getFirst_name() ,user.getLast_name() , user.getCitizenship(),user.getMobile(),user.getEmail(), user.getPassword());
        return "redirect:/register";
    }

}