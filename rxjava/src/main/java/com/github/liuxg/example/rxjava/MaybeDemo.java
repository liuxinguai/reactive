package com.github.liuxg.example.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.observers.DisposableMaybeObserver;

import java.util.concurrent.TimeUnit;

/**
 * @author xinguai.liu
 */
public class MaybeDemo {

    public static void main(String[] args) throws InterruptedException {
        DisposableMaybeObserver<String> observer = Maybe.just("liuxg")
                .delay(1, TimeUnit.SECONDS)
                .subscribeWith(new DisposableMaybeObserver<String>() {
                    @Override
                    public void onSuccess(@NonNull String s) {
                        System.out.println(Thread.currentThread().getName() + "receive : " + s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println(Thread.currentThread().getName() + "complete ...");
                    }
                });
        Thread.sleep(1200);
        observer.dispose();
    }

}
