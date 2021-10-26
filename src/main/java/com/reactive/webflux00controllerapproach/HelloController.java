package com.reactive.webflux00controllerapproach;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping(path = "/mono")
    public Mono<String> getMono(){
        return Mono.just("Welcome to RP Programming");
    }
    @GetMapping(path = "/flux", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> getFlux(){
        Flux<String> msg$ = Flux.just("Welcome ", "to ", "RP Programming")
                .delayElements(Duration.ofSeconds(1)).log();
        return msg$;
    }
}


