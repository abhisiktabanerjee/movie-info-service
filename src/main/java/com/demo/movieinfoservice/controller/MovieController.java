package com.demo.movieinfoservice.controller;

import java.util.ArrayList;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.movieinfoservice.MovieInfoServiceApplication;
import com.demo.movieinfoservice.model.Movie;
import com.demo.movieinfoservice.model.MovieSummary;
import com.demo.movieinfoservice.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	private static final Logger LOGGER = LogManager.getLogger(MovieController.class);
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private MovieService movieService;

	@Value("${api.key}")
	private String apiKey;

	@GetMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		final String METHODNAME = "getMovieInfo";
		LOGGER.info(METHODNAME + " STARTS");
		LOGGER.info("Movie ID received is {} ", movieId);
//		MovieSummary summary = template.getForObject(
//				"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieSummary.class);
		
		Movie m = movieService.fetchMovie(movieId);
		LOGGER.info(METHODNAME + "ENDS");
		return m;
	//	return new Movie(movieId, summary.getTitle(),summary.getOverview());
	//	return new Movie(movieId,"Testing title","Testing overview");
	}
}
