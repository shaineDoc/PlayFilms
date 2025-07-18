package ru.shainedoc.desktop.playfilms.service;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Slf4j
@Service
@Getter
public class TmdbService {

    private final RestTemplate restTemplate;
    private final ResourceLoader resourceLoader;
    private String apiKey;

    public TmdbService(RestTemplateBuilder restTemplateBuilder, ResourceLoader resourceLoader) {
        this.restTemplate = restTemplateBuilder.build();
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void loadApiKey() {
        try {
            Resource resource = resourceLoader.getResource("classpath:apikey.txt");
            List<String> lines = Files.readAllLines(Path.of(resource.getURI()));
            apiKey = lines.get(0).trim();
            log.info("TMDB API загружено успешно");
        } catch (IOException e) {
            log.error("Ошибка! файл недоступен TMDB API Key", e);
        }
    }

    // Тестовый метод
    public void printKey() {
        System.out.println("TMDB API key: " + apiKey);
    }
}
