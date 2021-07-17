package com.jb.CouponSystem.jobs;

import com.jb.CouponSystem.security.TokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoveExpiredTokens {
    private final TokenManager tokenManager;
    private static final int DEVELOPER_TEST = 1000*60*2;

    @Scheduled(fixedRate = DEVELOPER_TEST)
    public void run(){
        tokenManager.removeExpired();
        System.out.println("Expiration token job running...");
    }
}
