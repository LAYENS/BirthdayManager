package ru.elf.birthdaymanager.telegram.model;

import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.elf.birthdaymanager.telegram.controller.ControlRequest;

import java.util.Optional;

/**
 * Модель запроса
 * Created By Aleksey A Selikhov 2025
 */
public class BotRequest implements ControlRequest {
    private final Update update;

    public BotRequest(Update update) {
        this.update = update;
    }

    @Override
    public Optional<Long> getChatID() {
        if(update.hasMessage()) return Optional.of(update.getMessage().getChatId());
        if(update.hasCallbackQuery()) return Optional.of( update.getCallbackQuery().getMessage().getChatId());
        return Optional.empty();
    }
    @Override
    public Optional<Long> getUserID() {
        if (update.hasMessage()) return Optional.of(update.getMessage().getFrom().getId());
        if (update.hasCallbackQuery()) return Optional.of( update.getCallbackQuery().getFrom().getId());
        return Optional.empty();
    }

    @Override
    public Optional<String> getUserName() {
        if (update.hasMessage()) return Optional.ofNullable(update.getMessage().getFrom().getFirstName());
        if (update.hasCallbackQuery()) return Optional.ofNullable(update.getCallbackQuery().getFrom().getFirstName());
        return Optional.empty();
    }

    @Override
    public Optional<String> getData() {
        if (update.hasMessage()) return Optional.ofNullable(update.getMessage().getText());
        if (update.hasCallbackQuery()) return Optional.ofNullable(update.getCallbackQuery().getData());
        return Optional.empty();
    }
}
