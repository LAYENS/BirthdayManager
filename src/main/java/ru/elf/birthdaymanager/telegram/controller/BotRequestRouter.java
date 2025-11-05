package ru.elf.birthdaymanager.telegram.controller;

/**
 * Интерфейс роутера
 * Created By Aleksey A Selikhov 2025
 */
public interface BotRequestRouter {
    void route(ControlRequest request);
}
