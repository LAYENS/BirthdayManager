package ru.elf.birthdaymanager.telegram.bot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.elf.birthdaymanager.telegram.sender.BotMessageSender;

/**
 * Класс инициализации бота
 * Created By Aleksey A Selikhov 2025
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class BotInitializer {
    private final BotBirthdayManager tgBot;
    private final BotMessageSender sender;

    @EventListener({ContextRefreshedEvent.class})
    public void initBot(){
        try{
            TelegramBotsApi botAPI = new TelegramBotsApi(DefaultBotSession.class);
            botAPI.registerBot(tgBot);
            sender.setBot(tgBot);
        }catch(TelegramApiException e){
            log.error(e.getMessage());
        }
    }
}
