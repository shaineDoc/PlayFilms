package ru.shainedoc.desktop.playfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shainedoc.desktop.playfilms.models.Comment;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
}
