package com.example.mmdb;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.util.List;

import com.example.mmdb.movie.Movie;
import com.example.mmdb.movie.MovieRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DataImporter {

	private static final Logger log = LoggerFactory.getLogger(DataImporter.class);

	private final MovieRepository movieRepository;
	private final ObjectMapper objectMapper;

	public DataImporter(MovieRepository movieRepository, ObjectMapper objectMapper) {
		this.movieRepository = movieRepository;
		this.objectMapper = objectMapper;
	}

	@PostConstruct
//	TODO
//	check if data is imported
//	if not import the data
	public void init() {

	}

	private List<Movie> loadMoviesFromFile() {
		try {
			String content = IOUtils.toString(new ClassPathResource("/movies.json").getInputStream());
			return objectMapper.readValue(content, new TypeReference<List<Movie>>() {});
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

}


