package ru.shainedoc.desktop.playfilms.models.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Role {
    ADMIN ("Администратор"),
    USER ("Пользователь"),
    USER_PLUS ("Премиум-пользователь");

    private final String role;

    @Override
    public String toString() {
        return String.valueOf(role);
    }
}
