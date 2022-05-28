package application.controller;

import application.dao.ActorDAO;
import application.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ActorController {

    @Autowired
    private ActorDAO actorDAO;


    @GetMapping(value = "/actor")
    public String listActor(Model model) {
        model.addAttribute("actors", actorDAO.listActor());
        return "index";
    }
    @PostMapping(value = "actor/add")
    public String addActor(@RequestParam("ActorID") int actor_id, @RequestParam("ActorName") String name, @RequestParam("BirthDate")String birth_date, @RequestParam("Image") String image_name)
    {
        Actor actor = new Actor(actor_id,name,birth_date,image_name);
        actorDAO.insertActor(actor);

        return "redirect:/";
    }

    @GetMapping(value = "/delete/actor/{id}")
    public String deleteActor(@PathVariable("id") int id) {
        actorDAO.deleteActor(id);

        return "redirect:/";
    }
    @GetMapping(value = "/edit/actor/{id}")
    public String editActor(@PathVariable("id") int id, Model model) {
        Actor actor = actorDAO.getActorById(id);
        model.addAttribute("actor", actor);

        return "update-actor";
    }
    @GetMapping(value = "/actor/{id}")
    public String getFilmbyId(@PathVariable("id") int id, Model model) {
        model.addAttribute("actors", actorDAO.getActorById(id));
        return "actor";
    }

    @PostMapping(value = "/update/actor/{id}")
    public String updateActor(@RequestParam("ActorID") int actor_id, @RequestParam("Name") String name, @RequestParam("BirthDate") String birth_date,@RequestParam("Image") String image_name)
    {
        actorDAO.updateActor(actor_id ,name ,birth_date ,image_name);

        return "redirect:/";
    }























}
