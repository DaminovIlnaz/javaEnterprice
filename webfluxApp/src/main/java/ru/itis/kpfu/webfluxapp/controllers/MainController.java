package ru.itis.kpfu.webfluxapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.itis.kpfu.webfluxapp.models.Message;

import java.time.Duration;

@RestController
@RequestMapping
//Controllers - старый метод, Handlers - новый. Юзай что то одно

public class MainController {
    @GetMapping("/controller")
    public Flux<Message> getMess(){
        return Flux
                .just(
                        "Hello1",
                        "Hello2",
                        "Hello3",
                        "Hello4",
                        "Hello5",
                        "Hello6"
                ).map(Message::new).repeat(1000000);
    }
}
