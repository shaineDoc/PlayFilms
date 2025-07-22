package ru.shainedoc.desktop.playfilms.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TmdbMovieResponse {
    private int page;
    private List<MovieDto> results;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MovieDto {
        private Integer Id;
        private String title;
        private String overview;
        private String poster_path;
        private Double vote_average;
        private Integer vote_count;
        private String original_language;
        private LocalDate release_date;
    }
}

