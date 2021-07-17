package com.jb.CouponSystem.controllers;


import com.jb.CouponSystem.controllers.model.LoginModel;
import com.jb.CouponSystem.exceptions.MyException;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Data
public abstract class ClientController {
    public abstract ResponseEntity<?> login(LoginModel loginModel) throws MyException;
}
