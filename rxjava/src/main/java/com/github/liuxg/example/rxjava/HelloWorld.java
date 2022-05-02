package com.github.liuxg.example.rxjava;

import io.reactivex.rxjava3.core.Flowable;

/**
 * @author xinguai.liu
 */
public class HelloWorld {

    public static void main(String[] args) {
        Flowable.just("Hello world").subscribe(System.out::println);
    }
}
