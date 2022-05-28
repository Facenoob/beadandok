package application.controller;

import application.dao.UserDAO;
import application.model.Actor;
import application.model.Film;
import application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping(value = "/register")
    public String register() {
        return "reg";
    }


    @PostMapping(value = "/register")
    public String registerCheck(@RequestParam("firstname") String first_name, @RequestParam("lastname") String last_name, @RequestParam("password") String password,@RequestParam("email") String email)
    {
        int userid= userDAO.canRegister(email);
        if(userid==-1){return "redirect:register"; }
        User user = new User(userid, first_name ,last_name,password ,email);
        userDAO.insertUser(user);

        return "redirect:/";
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



}