package com.github.liuxg.example.webflux.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RequestMapping("pet")
@RestController
public class PetController {

    @PostMapping
    public Mono<Pet> add(@RequestBody Mono<Pet> pet) {
        return pet.flatMap(pet1 -> {
            log.info("保存{}",pet1);
            return Mono.just(pet1);
        }).onErrorResume(ex -> {
            log.error("exception",ex);
            return Mono.just(new Pet());
        });
    }

}
