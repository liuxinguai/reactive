package com.github.liuxg.example.webflux.controller;

import lombok.NonNull;

import java.util.concurrent.ConcurrentHashMap;

public class PersonHelper {

    private final static ConcurrentHashMap<String, Person> cache = new ConcurrentHashMap<>();

    static {

    }

    public static void add(@NonNull Person person) {
        cache.put(person.getId(), person);
    }

    public static Person get(@NonNull String id) {
        return cache.get(id);
    }

}
