package ru.elf.birthdaymanager.app.session;

import lombok.Getter;
import ru.elf.birthdaymanager.app.states.States;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Класс сессии пользователя
 * Created By Aleksey A Selikhov 2025
 */
@Getter
public class UserSession {

    private final Long chatId;
    private final String userName;
    private final Long userId;

    private final AtomicReference<States> currentState = new AtomicReference<>(States.DEFAULT);
    private final ConcurrentHashMap<String, String> encryptData = new ConcurrentHashMap<>();


    private final Map<Long, Boolean> notifyEnable = new ConcurrentHashMap<>();
    public UserSession(Long chatId, Long userId, String userName) {
        this.chatId = chatId;
        this.userName = userName;
        this.userId = userId;
    }
    public Long getChatId() {
        return chatId;
    }
    public String getUserName() {
        return userName;
    }
    public Long getUserId() {
        return userId;
    }
    public States getCurrentState() {
        return currentState.get();
    }
    public void setCurrentState(States state) {
        currentState.set(state);
    }

}
