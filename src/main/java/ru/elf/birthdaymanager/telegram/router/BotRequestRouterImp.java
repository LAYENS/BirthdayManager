package ru.elf.birthdaymanager.telegram.router;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.elf.birthdaymanager.app.session.SessionManager;
import ru.elf.birthdaymanager.telegram.controller.ControlRequest;
import ru.elf.birthdaymanager.telegram.controller.BotRequestRouter;

/**
 * Класс Роутер для маршрутизации команд.
 * Created By Aleksey A Selikhov 2025
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class BotRequestRouterImp implements BotRequestRouter {

    private final SessionManager sessionManager;

    @Override
    public void route(ControlRequest request) {
        Long chatId = request.getChatID().orElse(null);
        System.out.println("sads");
        if (chatId == null){
            log.info("чат не идентифицирован, работа с приложением невозможна");
            return;
        }
        Long userId = request.getUserID().orElseThrow();
        String userName = request.getUserName().orElseThrow();

        String text = request.getData().orElse("");


        log.info("Неизвестная команда для пользователя{}: {}", chatId, text);


    }

}