package ru.shainedoc.desktop.playfilms.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.shainedoc.desktop.playfilms.mapper.TmdbMapper;
import ru.shainedoc.desktop.playfilms.models.Movie;
import ru.shainedoc.desktop.playfilms.models.dto.TmdbMovieResponse;
import ru.shainedoc.desktop.playfilms.repository.MovieRepository;
import ru.shainedoc.model.MovieResponse;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@Getter
public class TmdbService {

    private final RestTemplate restTemplate;
    private final TmdbMapper tmdbMapper;
    private final MovieRepository movieRepository;
    private final ResourceLoader resourceLoader;
    // TODO: небезопасное решение, переделать (сделано для теста)
    @Value("${tmdb.api-key}")
    private String apiKey;

    @Value("https://image.tmdb.org/t/p/w600_and_h900_bestv2")
    private String urlForPoster;


    public TmdbService(
            RestTemplateBuilder restTemplateBuilder,
            TmdbMapper tmdbMapper,
            MovieRepository movieRepository,
            ResourceLoader resourceLoader
    ) {
        this.restTemplate = restTemplateBuilder.build();
        this.tmdbMapper = tmdbMapper;
        this.movieRepository = movieRepository;
        this.resourceLoader = resourceLoader;
    }


    public List<TmdbMovieResponse.MovieDto> fetchPopularMovies() {
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey + "&language=ru-RU&page=1";
        try {
            TmdbMovieResponse response = restTemplate.getForObject(url, TmdbMovieResponse.class);
            if (response != null) {
                log.info("Успешно получены фильмы: {}", response.getResults().size());
                return response.getResults();
            }
        } catch (Exception e) {
            log.error("Ошибка при получении фильмов", e);
        }
        return List.of();
    }

    /**
     * Данный метод подключается
     * к TMDB по API, который нужно заранее получить(зарегистрироваться)
     * прописав в application.yml
     * и получает список первых 20 фильмов с сохранением в БД
     */
    @Transactional
    public List<TmdbMovieResponse.MovieDto> saveFetchedMovies() {
        List<TmdbMovieResponse.MovieDto> fetched = fetchPopularMovies();
        for (TmdbMovieResponse.MovieDto dto : fetched) {
            // Не сохраняем дубликаты
            if (movieRepository.findByTmdbId(dto.getId()).isEmpty() || movieRepository.findByTitle(dto.getTitle()).isEmpty()) {
                var movie = Movie.builder()
                        .tmdbId(dto.getId())
                        .title(dto.getTitle())
                        .description(dto.getOverview())
                        .duration(dto.getVote_count())
                        .posterUrl(urlForPoster + dto.getPoster_path())
                        .trailerUrl(urlForPoster + dto.getPoster_path())
                        .build();
                movieRepository.save(movie);
                log.info("Сохранён фильм: {}", movie.getTitle());
            } else {
                log.debug("Фильм уже существует: {}", dto.getTitle());
            }
        }
        return fetched;
    }

    @Transactional(readOnly = true)
    public List<MovieResponse> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(movie -> {
                    MovieResponse response = new MovieResponse();
                    response.setId(movie.getMovieId());
                    response.setTitle(movie.getTitle());
                    response.setDescription(movie.getDescription());
                    // остальные поля
                    return response;
                })
                .toList();
    }
}