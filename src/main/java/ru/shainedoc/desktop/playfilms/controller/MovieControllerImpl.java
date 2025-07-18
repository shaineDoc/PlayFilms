package ru.shainedoc.desktop.playfilms.controller;

import org.springframework.http.ResponseEntity;
import ru.shainedoc.api.MoviesApi;
import ru.shainedoc.model.MovieResponse;

import java.util.List;

public class MovieControllerImpl implements MoviesApi {

    @Override
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        return null;
    }
}
