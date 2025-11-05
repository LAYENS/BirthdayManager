package ru.elf.birthdaymanager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.elf.birthdaymanager.telegram.config.BotConfig;

@SpringBootTest
class BirthdayManagerApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void TestBotConfig() {
        BotConfig config = new BotConfig();
        System.out.println(config.getBotToken());
    }
}
