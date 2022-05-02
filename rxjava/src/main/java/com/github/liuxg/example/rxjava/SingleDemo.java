package com.github.liuxg.example.rxjava;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * @author xinguai.liu
 */
public class SingleDemo {

    public static void main(String[] args) throws InterruptedException {
        Disposable d = Single.just("Hello World")
                .delay(2, TimeUnit.SECONDS, Schedulers.io())
                .subscribeWith(new DisposableSingleObserver<String>() {
                    @Override
                    public void onStart() {
                        System.out.println("Started");
                    }

                    @Override
                    public void onSuccess(String value) {
                        System.out.println("Success: " + value);
                    }

                    @Override
                    public void onError(Throwable error) {
                        error.printStackTrace();
                    }
                });

        Thread.sleep(5000);

        d.dispose();
    }
}
