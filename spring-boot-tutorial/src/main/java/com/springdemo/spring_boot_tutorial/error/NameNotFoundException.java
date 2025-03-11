package com.springdemo.spring_boot_tutorial.error;

public class NameNotFoundException extends Exception {

    public NameNotFoundException() {
    }

    public NameNotFoundException(String message) {
        super(message);
    }

    public NameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameNotFoundException(Throwable cause) {
        super(cause);
    }

    public NameNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
