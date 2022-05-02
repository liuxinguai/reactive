package com.github.liuxg.example.rxjava;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinguai.liu
 */
public class FlowableDemo6 {

    public static void main(String[] args) {
        Flowable.range(1,10)
                .flatMap(value -> Flowable.just(value)
                        .subscribeOn(Schedulers.computation())
                        .map(w -> w * w)).blockingSubscribe(System.out::println);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer integer = list.stream().reduce(3, Integer::sum);
        System.out.println(integer);
        System.out.println("------------------------");
        Flowable.range(1,5)
                .parallel()
                .runOn(Schedulers.computation())
                .map(v -> v * v)
                .sequential()
                .blockingSubscribe(System.out::println);
    }

}
