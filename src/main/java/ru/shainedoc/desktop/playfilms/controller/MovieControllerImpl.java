package ru.shainedoc.desktop.playfilms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.shainedoc.api.MoviesApi;
import ru.shainedoc.desktop.playfilms.models.dto.TmdbMovieResponse;
import ru.shainedoc.desktop.playfilms.service.TmdbService;
import ru.shainedoc.model.MovieResponse;

import java.util.List;
@Controller
@RequiredArgsConstructor
public class MovieControllerImpl implements MoviesApi {

private final TmdbService tmdbService;

    @Override
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        List<MovieResponse> movies = tmdbService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @Override
    public ResponseEntity<List<MovieResponse>> importMoviesFromTmdb() {
        return null;
    }


    @GetMapping("/debug-tmdb")
    public ResponseEntity<List<TmdbMovieResponse.MovieDto>> debugFetchTmdbMovies() {
        List<TmdbMovieResponse.MovieDto> movies = tmdbService.saveFetchedMovies();
        return ResponseEntity.ok(movies);
    }


}
