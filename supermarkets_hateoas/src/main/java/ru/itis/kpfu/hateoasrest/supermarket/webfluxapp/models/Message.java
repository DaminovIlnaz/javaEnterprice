package ru.itis.kpfu.hateoasrest.supermarket.webfluxapp.models;

public class Message {

    private String mess;

    public Message(String mess) {
        this.mess = mess;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
}
