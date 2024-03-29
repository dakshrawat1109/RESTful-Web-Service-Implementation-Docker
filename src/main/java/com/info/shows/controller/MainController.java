package com.info.shows.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.shows.service.MovieShowsCastService;

import com.info.shows.model.Shows;
import com.info.shows.model.Cast;


@RestController
public class MainController {
	@Autowired
	MovieShowsCastService tvShowCastService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/")
	public String defaultMapping() {
		return "This is Home page. Change the uri by adding /shows";
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/shows")
	public List<Shows> getAllShows(){
		return tvShowCastService.getAllMovieShows();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value= "/shows/{showId}")
	public Shows getByShowId(@PathVariable int showId) {
		return tvShowCastService.findShowById(showId);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value= "/shows/{showId}/cast")
	public List<Cast> getAllShowCasts(@PathVariable int showId) {
		return tvShowCastService.getAllShowCasts(showId);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/shows/{showId}/cast/{castId}")
	public Cast getShowOrderById(@PathVariable("showId") int showId, @PathVariable("castId") int castId) {
		return tvShowCastService.findShowCastById(showId, castId);
	}
}
