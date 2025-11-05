package ru.elf.birthdaymanager.telegram.sender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.elf.birthdaymanager.app.components.Buttons;
import ru.elf.birthdaymanager.telegram.bot.BotBirthdayManager;
import ru.elf.birthdaymanager.telegram.components.ButtonsConverter;

import java.io.Serializable;

/**
 * Класс Отправки сообщений в телеграм
 * Created By Aleksey A Selikhov 2025
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class BotMessageSender implements BotSender {

    private BotBirthdayManager bot;
    public void setBot(BotBirthdayManager bot) {
        this.bot = bot;
    }
    @Override
    public void sendText(Long chatID, String text, Buttons keyboard) {
        SendMessage msg = new SendMessage();
        msg.setChatId(chatID);
        msg.setText(text);
        if (keyboard != null) {
            msg.setReplyMarkup(ButtonsConverter.toTelegram(keyboard));
        }
        executeSafely(msg);
    }

    @Override
    public Serializable execute(BotApiMethod<?> method) throws TelegramApiException {
        return bot.execute(method);
    }


    private void executeSafely(BotApiMethod<?> method) {
        try { bot.execute(method); }
        catch (Exception ex) { log.error("Ошибка отправки: {}", ex.getMessage(), ex); }
    }

}
