package com.example.mmdb.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

@Service
public class MovieService {

	private static final Logger log = LoggerFactory.getLogger(MovieService.class);

	private List<String> keys = Arrays.asList("axe.mp4", "cocacola.mp4", "heineken.mp4", "mercedes.mp4");

	private final MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public Page<Movie> listMovies(Pageable pageable) {
		Page<Movie> movies = movieRepository.findAll(pageable);
		movies.stream().forEach(m -> addKey(m));
		return movies;
	}

	public Page<Movie> fullTextSearch(String searchTerm, Pageable pageable) {
		Page<Movie> movies = movieRepository.search(queryStringQuery(searchTerm), pageable);
		movies.stream().forEach(m -> addKey(m));
		return movies;
	}

	private void addKey(Movie movie) {
		movie.setKey(keys.get(movie.getYear() % keys.size()));
	}
}
