package ru.itis.kpfu.hateoasrest.supermarket.webfluxapp.handlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itis.kpfu.hateoasrest.supermarket.webfluxapp.models.Message;

@Component
/*Controllers - старый метод, Handlers - новый. Юзай что то одно*/
public class  GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {

        Flux<Message> data = Flux.just(
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello"
        ).map(Message::new);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(data,Message.class);
    }
}