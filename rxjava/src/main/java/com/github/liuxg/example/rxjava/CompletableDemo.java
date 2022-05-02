package com.github.liuxg.example.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.observers.DisposableCompletableObserver;

import java.util.concurrent.TimeUnit;

/**
 * @author xinguai.liu
 */
public class CompletableDemo {

    public static void main(String[] args) throws InterruptedException {
        DisposableCompletableObserver observer = Completable.complete()
                .delay(1, TimeUnit.SECONDS)
                .subscribeWith(new DisposableCompletableObserver() {

                    @Override
                    protected void onStart() {
                        System.out.println(Thread.currentThread().getName() + "start ..");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println(Thread.currentThread().getName() + "complete...");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }
                });
        Thread.sleep(2000);
        observer.dispose();
    }
}
