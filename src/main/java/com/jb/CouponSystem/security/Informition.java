package com.jb.CouponSystem.security;

import com.jb.CouponSystem.facade.ClientFacade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Informition {

    private ClientFacade clientFacade;
    private LocalDateTime time;
}
