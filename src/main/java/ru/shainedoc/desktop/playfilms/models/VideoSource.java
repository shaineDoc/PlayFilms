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

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VideoSource {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name  = "source_id", unique = true, nullable = false)
    private UUID id;
    @Column(name = "quality",nullable = false)
    private String quality;
    @Column(name = "language", nullable = false)
    private String language;
    @Column(name = "soruce_url", nullable = false)
    private String soruceUrl;
    @Column(name = "source_type", nullable = false)
    private String sourceType;

}
