package ru.elf.birthdaymanager.telegram.components;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.elf.birthdaymanager.app.components.Buttons;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс конвертации кнопок в формат, подходящий для телеграмма
 * Created By Aleksey A Selikhov 2025
 */
public class ButtonsConverter {

    public static InlineKeyboardMarkup toTelegram(Buttons buttons) {
        List<List<InlineKeyboardButton>> tgRows = new ArrayList<>();

        for (List<Buttons.Button> row : buttons.getRows()) {
            List<InlineKeyboardButton> tgRow = new ArrayList<>();
            for (Buttons.Button btn : row) {
                InlineKeyboardButton tgBtn = new InlineKeyboardButton();
                tgBtn.setText(btn.getLabel());
                tgBtn.setCallbackData(btn.getData());
                tgRow.add(tgBtn);
            }
            tgRows.add(tgRow);
        }

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.setKeyboard(tgRows);
        return markup;
    }

}