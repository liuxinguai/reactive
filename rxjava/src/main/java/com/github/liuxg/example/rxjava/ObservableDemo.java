package com.github.liuxg.example.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.DisposableObserver;

import java.util.concurrent.TimeUnit;

/**
 * @author xinguai.liu
 */
public class ObservableDemo {

    public static void main(String[] args) throws InterruptedException {
        DisposableObserver<String> observer = Observable.just("hello world")
                .delay(1, TimeUnit.SECONDS)
                .subscribeWith(new DisposableObserver<String>() {
                    @Override
                    public void onNext(@NonNull String s) {
                        System.out.println(Thread.currentThread().getName() + " consumer : " + s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println(Thread.currentThread().getName() + " Done!");
                    }
                });
        Thread.sleep(2000);
        observer.dispose();
    }
}
