package ru.shainedoc.desktop.playfilms;

import org.springframework.boot.SpringApplication;

public class TestPlayFilmsApplication {

    public static void main(String[] args) {
        SpringApplication.from(PlayFilmsApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
