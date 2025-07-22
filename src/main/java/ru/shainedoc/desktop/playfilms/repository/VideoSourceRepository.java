package ru.shainedoc.desktop.playfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shainedoc.desktop.playfilms.models.VideoSource;

import java.util.UUID;

public interface VideoSourceRepository extends JpaRepository<VideoSource, UUID> {
}
