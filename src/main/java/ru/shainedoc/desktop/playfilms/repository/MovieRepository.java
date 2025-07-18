package ru.shainedoc.desktop.playfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shainedoc.desktop.playfilms.models.Movie;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
}
