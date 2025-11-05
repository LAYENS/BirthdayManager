package ru.elf.birthdaymanager.telegram.bot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.elf.birthdaymanager.telegram.controller.BotRequestRouter;
import ru.elf.birthdaymanager.telegram.model.BotRequest;

/**
 * Класс для передачи полученной команды от пользователя в роутер
 * Created By Aleksey A Selikhov 2025
 */
@Service
@RequiredArgsConstructor
public class BotUpdateService {
    private final BotRequestRouter router;

    public void handleRequest(Update update) {
        BotRequest request = new BotRequest(update);
        router.route(request);
    }
}
