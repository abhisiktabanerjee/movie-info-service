package com.demo.movieinfoservice.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.movieinfoservice.DAO.MovieDAO;
import com.demo.movieinfoservice.model.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	private static final Logger LOGGER = LogManager.getLogger(MovieServiceImpl.class);

	@Autowired
	private MovieDAO movieDao;

	@Override
	public Movie fetchMovie(String movieId) {
		final String METHODNAME = "fetchMovieSERVICE";
		LOGGER.info(METHODNAME + " STARTS");
		LOGGER.info("Movie ID received is {} ", movieId);

		try {
			Movie movie = movieDao.fetchMovie(movieId);
			if (movie == null) {
				throw new Exception("Movie not found ");
			} else {
				return movie;
			}
		} catch (Exception e) {
			LOGGER.error("Fetching movie failed from Service Layer :", e);
			LOGGER.info(METHODNAME + "ENDS");
			return new Movie("","Movie not found","");

		}

	}

}
