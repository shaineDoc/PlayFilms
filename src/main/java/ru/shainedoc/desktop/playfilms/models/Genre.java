package ru.shainedoc.desktop.playfilms.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.shainedoc.desktop.playfilms.models.enums.GenreList;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name  = "genre_id", unique = true, nullable = false)
    private UUID id;

    private GenreList genreList;
}
