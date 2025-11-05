package ru.elf.birthdaymanager.app.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс формирования кнопок для телеграм бота
 * Created By Aleksey A Selikhov 2025
 */
public class Buttons {
    private final List<List<Button>> rows = new ArrayList<>();

    public void addRow(Button...buttons){
        rows.add(Arrays.asList(buttons));
    }

    public List<List<Button>> getRows(){
        return rows;
    }

    public static class Button {
        private final String label;
        private final String data;

        public Button(String label, String data) {
            this.label = label;
            this.data = data;
        }
        public String getLabel(){
            return label;
        }

        public String getData() {
            return data;
        }
    }
}
