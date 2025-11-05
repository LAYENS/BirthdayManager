package ru.elf.birthdaymanager.telegram.controller;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.Serializable;

/**
 * Интерфейс для взаимодействия с ботом
 * Created By Aleksey A Selikhov 2025
 */
public interface BotExecutor {
    <T extends Serializable, M extends BotApiMethod<T>> T execute(M method) throws TelegramApiException;
    Message execute(SendPhoto sendPhoto) throws TelegramApiException;
    Message execute(SendVideo sendVideo) throws TelegramApiException;
    File loadFile(String path) throws TelegramApiException;
}
