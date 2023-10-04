package com.dim.Models.message;
import java.io.Serializable;

public class MyObject implements Serializable {
    private String message;

    public MyObject(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}