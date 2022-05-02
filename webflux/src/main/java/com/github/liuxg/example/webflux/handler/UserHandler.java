package com.github.liuxg.example.webflux.handler;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserHandler {

    private static final ConcurrentHashMap<String,UserEntity> cache = new ConcurrentHashMap<>();

    public UserEntity getUser(String userId) {
        return cache.get(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    public void add(@NonNull @RequestBody UserEntity userEntity) {
        cache.put(userEntity.getId(),userEntity);
    }

}
