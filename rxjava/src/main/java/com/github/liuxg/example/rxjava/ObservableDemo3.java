package com.github.liuxg.example.rxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xinguai.liu
 */
public class ObservableDemo3 {

    public static void main(String[] args) {

        //0
        final AtomicInteger count = new AtomicInteger();
        Observable.range(1, 10)
                .doOnNext(ignored -> count.incrementAndGet())
                .ignoreElements()
                .andThen(Single.just(count.get()))
                .blockingSubscribe(System.out::println);

        //10
        AtomicInteger count2 = new AtomicInteger();
        Observable.range(1, 10)
                .doOnNext(ignored -> count2.incrementAndGet())
                .ignoreElements()
                .andThen(Single.defer(() -> Single.just(count2.get())))
                .subscribe(System.out::println);

        //10
        AtomicInteger count3 = new AtomicInteger();
        Observable.range(1, 10)
                .doOnNext(ignored -> count3.incrementAndGet())
                .ignoreElements()
                .andThen(Single.fromCallable(() -> count3.get()))
                .subscribe(System.out::println);
    }

}
