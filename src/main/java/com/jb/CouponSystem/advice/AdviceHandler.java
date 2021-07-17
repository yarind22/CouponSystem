package com.jb.CouponSystem.advice;

import com.jb.CouponSystem.exceptions.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class AdviceHandler {

    @ExceptionHandler(MyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails exception(Exception e) {
        return new ErrorDetails("exception", e.getMessage());
    }

}
