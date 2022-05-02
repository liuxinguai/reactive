package com.github.liuxg.example.rxjava;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @author xinguai.liu
 */
public class FlowableDemo5 {

    public static void main(String[] args) {
        Flowable.range(1,5)
                .map(value -> value * 2)
                .observeOn(Schedulers.computation())
                .blockingSubscribe(System.out::println);
    }

}
