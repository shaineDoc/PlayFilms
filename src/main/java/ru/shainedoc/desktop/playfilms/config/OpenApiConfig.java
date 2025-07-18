package ru.shainedoc.desktop.playfilms.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Play Films",
                description = "Данный сервис позволяет просматривать " +
                        "списки популярных фильмов, их описание, жанр" +
                        " и позволяет просматривать в режиме онлайн ",
                version = "dev"
        ),
        externalDocs = @ExternalDocumentation(
                url = ""
        )
)
public class OpenApiConfig {
}
