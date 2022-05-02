package com.github.liuxg.example.webflux.handler;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserEntity implements Serializable {

    private String id;

    private String name;

}
