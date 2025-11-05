package ru.elf.birthdaymanager.telegram.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.elf.birthdaymanager.telegram.config.BotConfig;
import ru.elf.birthdaymanager.telegram.controller.BotExecutor;

import java.io.File;
import java.io.Serializable;

/**
 * Класс основных действий с ботом: получение токена, юзера, данных от пользователя, файлов
 * Created By Aleksey A Selikhov 2025
 */
@Component
public class BotBirthdayManager extends TelegramLongPollingBot implements BotExecutor {

        private final BotUpdateService updateService;
        private final BotConfig config;

        public BotBirthdayManager(BotUpdateService updateService, BotConfig config) {
            this.updateService = updateService;
            System.out.println("test");
            this.config = config;
        }

        @Override
        public void onUpdateReceived(Update update) {
            updateService.handleRequest(update);
        }
        @Override
        public  <T extends Serializable, M extends BotApiMethod<T>> T execute(M method) throws TelegramApiException {
            return super.execute(method);
        }
        @Override
        public File loadFile(String filePath) throws TelegramApiException {
            return super.downloadFile(filePath);
        }
        @Override
        public String getBotToken() {   return config.getBotToken(); }
        @Override
        public String getBotUsername(){ return config.getBotName(); }

}


