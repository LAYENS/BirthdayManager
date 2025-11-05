package ru.elf.birthdaymanager.telegram.config;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Класс конфигурации бота
 * Получение токета и имени
 * Created By Aleksey A Selikhov 2025, Oct 13
 */
@Component
@Data
public class BotConfig {
    @Value("${bot.name}")
    private String botName;
    @Value("${bot.token}")
    private String botToken;
}
