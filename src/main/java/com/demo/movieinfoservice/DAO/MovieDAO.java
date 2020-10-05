package com.demo.movieinfoservice.DAO;


import com.demo.movieinfoservice.model.Movie;


public interface MovieDAO {
	
	public Movie fetchMovie(String movieId);

}
