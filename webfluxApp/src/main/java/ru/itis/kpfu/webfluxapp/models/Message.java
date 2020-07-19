package ru.itis.kpfu.webfluxapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Message {
    @Id
    private Long id;
    private String mess;
    public Message(String mess) {
        this.mess = mess;
    }
}
