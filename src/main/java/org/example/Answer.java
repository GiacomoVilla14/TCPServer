package org.example;

import com.google.gson.Gson;

public class Answer {
    Boolean result;
    String message;


    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Answer(Boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    String asJson() {
        Gson g = new Gson();
        String toJson = g.toJson(this);
        return toJson;
    }

}
