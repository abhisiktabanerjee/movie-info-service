package com.demo.movieinfoservice.controller;

import java.util.ArrayList;

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

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private RestTemplate template;

	@Value("${api.key}")
	private String apiKey;

	@GetMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {

		MovieSummary summary = template.getForObject(
				"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieSummary.class);
		

		return new Movie(movieId, summary.getTitle(),summary.getOverview());
	//	return new Movie(movieId,"Testing title","Testing overview");
	}
}
