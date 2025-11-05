package ru.elf.birthdaymanager.telegram.controller;

import java.util.Optional;

/**
 * интерфейс для получения данных от бота по пользователю
 * Created By Aleksey A Selikhov 2025
 */
public interface ControlRequest {
    Optional<Long> getChatID();
    Optional<Long> getUserID();
    Optional<String> getUserName();
    Optional<String> getData();
}
