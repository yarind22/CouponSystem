package com.jb.CouponSystem.exceptions;


public enum GenericExceptions {

    LOGIN_FAILED("Invalid user name and password"),
    INVALID_TOKEN("Invalid token"),
    ALREADY_USED("inavlid user name and password combination"),
    INVALID_UPDATE("Canot update information"),
    INVALID_OPERATION("Canot execute the operation"),
    ALREADY_EXPIRED("Object is already expired");

    private String description;

    GenericExceptions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
