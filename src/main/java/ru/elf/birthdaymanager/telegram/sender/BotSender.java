package ru.elf.birthdaymanager.telegram.sender;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.elf.birthdaymanager.app.components.Buttons;

import java.io.Serializable;

/**
 * Интерфейс отправки сообщений в телеграм
 * Created By Aleksey A Selikhov 2025
 */
public interface BotSender {
   void sendText(Long chatID, String text, Buttons buttons);
    Serializable execute(BotApiMethod<?> method) throws TelegramApiException;
}