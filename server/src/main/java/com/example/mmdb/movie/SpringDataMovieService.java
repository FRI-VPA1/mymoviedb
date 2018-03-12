package com.example.mmdb.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SpringDataMovieService implements MovieService{

	private static final Logger log = LoggerFactory.getLogger(SpringDataMovieService.class);

	private List<String> keys = Arrays.asList("axe.mp4", "cocacola.mp4", "heineken.mp4", "mercedes.mp4");

	private final MovieRepository movieRepository;

	public SpringDataMovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public Page<Movie> listInitialMovies(Pageable pageable) {
//		TODO
		return null;
	}

	public Page<Movie> fullTextSearch(String searchTerm, Pageable pageable) {
//		TODO
		return null;
	}

	private void addKey(Movie movie) {
		movie.setKey(keys.get(movie.getYear() % keys.size()));
	}
}
