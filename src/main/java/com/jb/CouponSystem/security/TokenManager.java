package com.jb.CouponSystem.security;


import com.jb.CouponSystem.facade.ClientFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class TokenManager {
    private static final int MINUTES_BEFORE_DELETE=2;
    private final Map<String, Informition> tokenContainer;

    public String generateToken(ClientFacade clientFacade) {
        String token = UUID.randomUUID().toString();
        Informition informition = Informition.builder()
                .clientFacade(clientFacade)
                .time(LocalDateTime.now())
                .build();
        tokenContainer.put(token, informition);
        return token;
    }

    public void deleteToken(String token) {
        tokenContainer.remove(token);
    }


    public boolean isExist(String token) {
        return tokenContainer.get(token) != null;
    }

    public void updateTokenTime(String token) {
        tokenContainer.get(token).setTime(LocalDateTime.now());
    }


    private static boolean removeExpired(Map.Entry<String,Informition>container) {
        return container.getValue().getTime().isBefore(LocalDateTime.now().minusMinutes(MINUTES_BEFORE_DELETE));
    }

    public void removeExpired() {
        tokenContainer.entrySet().removeIf(TokenManager::removeExpired);
    }
}
