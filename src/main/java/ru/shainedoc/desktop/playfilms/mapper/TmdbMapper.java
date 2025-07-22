package ru.shainedoc.desktop.playfilms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.shainedoc.desktop.playfilms.config.MapstructConfig;
import ru.shainedoc.desktop.playfilms.models.Movie;
import ru.shainedoc.desktop.playfilms.models.dto.TmdbMovieResponse;
import ru.shainedoc.model.MovieResponse;

@Mapper(config = MapstructConfig.class, componentModel = "spring")
public interface TmdbMapper {
    
    @Mapping(target = "id", source = "movie.tmdbId")
    @Mapping(target = "title", source = "movie.title")
    @Mapping(target = "overview", source = "movie.description")
    @Mapping(target = "poster_path", source = "movie.posterUrl")
    @Mapping(target = "release_date", source = "movie.releaseYear")
    @Mapping(target = "vote_average", source = "movie.duration")
    TmdbMovieResponse.MovieDto toTmdbMovieResponse(Movie movie);

    // Новый маппинг из TMDB DTO в Movie entity
    @Mapping(target = "movieId", ignore = true)
    @Mapping(target = "tmdbId", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "overview")
    @Mapping(target = "posterUrl", source = "poster_path")
    @Mapping(target = "releaseYear", source = "release_date")
    @Mapping(target = "duration", source = "vote_average")
    Movie toMovieEntity(TmdbMovieResponse.MovieDto dto);


    MovieResponse toResponse(Movie movie);
}
