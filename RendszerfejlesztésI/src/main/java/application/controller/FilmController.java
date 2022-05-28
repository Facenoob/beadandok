package application.controller;

import application.dao.FilmDAO;
import application.dao.ActorDAO;
import application.model.Actor;
import application.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDAO;
	@Autowired
	private ActorDAO actorDAO;

	@GetMapping(value = "/")
	public String listFilm(Model model) {
		model.addAttribute("films", filmDAO.listFilms());
		return "index";
	}


	@PostMapping(value = "/add")
	public String addFilm(@RequestParam("filmID") int movie_id, @RequestParam("filmCime") String title, @RequestParam("kiadasEve") int release,@RequestParam("korhatár") int age_restriction,   @RequestParam("rendező") String director , @RequestParam("JatekIdo") int game_time, @RequestParam("pontszam") float rate, @RequestParam("image") String image)
	{
		Film film = new Film(movie_id ,title ,release ,  age_restriction, director,game_time, rate,image);
		filmDAO.insertFilm(film);

		return "redirect:/";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteFilm(@PathVariable("id") int id) {
		filmDAO.deleteFilm(id);
		
		return "redirect:/";
	}
	@GetMapping(value = "/film/{id}")
	public String getFilmbyId(@PathVariable("id") int id, Model model) {
		model.addAttribute("film", filmDAO.getFilmById(id));
		model.addAttribute("actors", actorDAO.getActorById(id));
		return "film";
	}


	@GetMapping(value = "/edit/{id}")
	public String editFilm(@PathVariable("id") int id, Model model) {
		Film film = filmDAO.getFilmById(id);
		model.addAttribute("film", film);

		return "update-film";
	}

	@PostMapping(value = "/update/{id}")
	public String updateFilm(@RequestParam("filmID") int movie_id, @RequestParam("filmCime") String title, @RequestParam("kiadasEve") int release,@RequestParam("korhatár") int age_restriction,   @RequestParam("rendező") String director , @RequestParam("JatekIdo") int game_time, @RequestParam("pontszam") float rate )
	{
		filmDAO.updateFilm(movie_id ,title ,release ,  age_restriction, director,game_time, rate);

		return "redirect:/";
	}

}