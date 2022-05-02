package com.github.liuxg.example.webflux.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("red")
@RestController
public class RedController {

    @RequestMapping("get/{segment}")
    public String get(@RequestHeader(value = "X-Request-Red",required = false) String red, @PathVariable("segment") String segment) {
        log.info("red : {},segment:{}",red,segment);
        return "haha";
    }

}
