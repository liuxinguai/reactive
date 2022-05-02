package com.github.liuxg.example.rxjava;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;

import java.util.concurrent.TimeUnit;

/**
 * @author xinguai.liu
 */
public class FlowableDemo {

    public static void main(String[] args) throws InterruptedException {
        DisposableSubscriber<String> subscribe = Flowable.just("hello world")
                .delay(1, TimeUnit.SECONDS)
                .subscribeWith(new DisposableSubscriber<String>() {

                    @Override
                    protected void onStart() {
                        System.out.println(Thread.currentThread().getName()+" consumer start ...");
                        request(1);
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(Thread.currentThread().getName() + " consumer : "+s);
                        request(1);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println(Thread.currentThread().getName() + " consumer error : " + t.getMessage());
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println(Thread.currentThread().getName()+" consumer done! ");
                    }
                });
        Thread.sleep(3000);
        subscribe.dispose();
    }
}
