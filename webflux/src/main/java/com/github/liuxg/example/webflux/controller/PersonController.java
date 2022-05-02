package com.github.liuxg.example.webflux.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("person")
@RestController
public class PersonController {

    @GetMapping("{id}")
    public Person get(@PathVariable("id") String id) {
        return PersonHelper.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Person person) {
        PersonHelper.add(person);
    }
}
