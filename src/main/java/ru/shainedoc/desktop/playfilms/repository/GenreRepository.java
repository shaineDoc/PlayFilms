package ru.shainedoc.desktop.playfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shainedoc.desktop.playfilms.models.Genre;

import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, UUID> {
}
