package ru.shainedoc.desktop.playfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shainedoc.desktop.playfilms.models.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository <User, UUID> {
}
