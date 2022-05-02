package com.github.liuxg.example.webflux.controller;

import lombok.Data;

import java.io.Serializable;

@Data
public class Pet implements Serializable {

    private String id;

    private String name;
}
