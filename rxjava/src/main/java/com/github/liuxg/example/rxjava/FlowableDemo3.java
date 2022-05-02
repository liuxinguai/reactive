package com.github.liuxg.example.rxjava;

import io.reactivex.rxjava3.core.Flowable;

/**
 * @author xinguai.liu
 */
public class FlowableDemo3 {

    public static void main(String[] args) {
        Flowable.range(1, 5)
                .map(value -> value * value)
                .filter(value -> value % 3 != 0)
                .subscribe(System.out::println).dispose();
    }

}
