package com.example.mmdb.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {
	Page<Movie> listInitialMovies(Pageable pageable);
	Page<Movie> fullTextSearch(String searchTerm, Pageable pageable);
}
