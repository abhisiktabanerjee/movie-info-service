package com.demo.movieinfoservice.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.demo.movieinfoservice.model.Movie;

@Repository
@Transactional
public class MovieDAOImpl implements MovieDAO {

	private static final Logger LOGGER = LogManager.getLogger(MovieDAOImpl.class);

	@Autowired
	public EntityManagerFactory emf;

	@Override
	public Movie fetchMovie(String movieId) {
		final String METHODNAME = "fetchMovieDAO";
		LOGGER.info(METHODNAME + " STARTS");
		LOGGER.info("movieId received is {}", movieId);
		EntityManager em = emf.createEntityManager();
		Movie movie = new Movie();
		String fetch_movie = "Select * from movie_data where movieid = '" + movieId + "'";
		try {
			Query query = em.createNativeQuery(fetch_movie);
			List<Object[]> resultList = query.getResultList();
			for (Object[] m : resultList) {
				if (m != null) {
					movie.setMovieId(m[0] == null ? "" : (String) m[0]);
					movie.setDescription(m[2] == null ? "" : (String) m[2]);
					movie.setMovieName(m[1] == null ? "" : (String) m[1]);
				} else {
					throw new Exception("Movie not found in DB");
				}
			}

		} catch (Exception e) {
			LOGGER.error("Fetching movie from DB failed with error :", e);
		}
		LOGGER.info(METHODNAME + " ENDS");
		return movie;
	}

}
