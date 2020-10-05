package com.demo.movieinfoservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie_data")
public class Movie {

	@Id
	@Column(name = "movieid")
	private String movieId;

	@Column(name = "title")
	private String movieName;

	@Column(name = "description")
	private String description;

}
