package ru.shainedoc.desktop.playfilms.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shainedoc.desktop.playfilms.models.Rating;

import java.util.UUID;

public interface RatingRepository  extends CrudRepository<Rating, UUID> {
}
