package ru.shainedoc.desktop.playfilms.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Play Films",
                description = "Данный сервис предназначен для домашнего" +
                        "ознакомительного просмотра фильмов, взятых из открытых" +
                        "источников",
                version = "dev"
        ),
        externalDocs = @ExternalDocumentation(
                url = ""
        )
)
public class OpenApiConfig {
}
