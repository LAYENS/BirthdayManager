package ru.elf.birthdaymanager.app.session;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Класс менеджер сессий пользователей
 * Created By Aleksey A Selikhov 2025
 */
@Component
public class SessionManager {
    private final ConcurrentHashMap<Long, UserSession> sessions = new ConcurrentHashMap<Long, UserSession>();

    public UserSession getOrCreateSession(Long chatId, Long userId, String userName){
        return sessions.computeIfAbsent(chatId, id->new UserSession(chatId, userId, userName));
    }
    public void removeSession(Long chatId){
        sessions.remove(chatId);
    }
}
