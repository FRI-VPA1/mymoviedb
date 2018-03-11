package com.example.mmdb.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

@Service
public class MovieService {

	private final MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public Page<Movie> listMovies(Pageable pageable) {
		return movieRepository.findAll(pageable);
	}

	public Page<Movie> fullTextSearch(String searchTerm, Pageable pageable) {
		return movieRepository.search(queryStringQuery(searchTerm),pageable);
	}

}
