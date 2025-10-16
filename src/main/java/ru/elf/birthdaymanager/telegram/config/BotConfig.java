package ru.elf.birthdaymanager.telegram.config;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Класс конфигурации бота
 * Created By Aleksey A Selikhov 2025, Oct 13
 */
@Component
@ConfigurationProperties(prefix = "bot")
@Data
public class BotConfig {
    @Value("${BOT_NAME}")
    private String botName;
    @Value("${BOT_TOKEN}")
    private String botToken;
}
