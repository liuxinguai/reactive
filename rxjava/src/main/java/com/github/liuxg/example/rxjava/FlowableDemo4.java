package com.github.liuxg.example.rxjava;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @author xinguai.liu
 */
public class FlowableDemo4 {

    public static void main(String[] args) throws InterruptedException {
        Flowable.fromCallable(() -> {
            Thread.sleep(1000);
            return "Done!";
        })
                .subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.single())
                .subscribe(System.out::println,Throwable::printStackTrace);
        Thread.sleep(2000);
    }

}
