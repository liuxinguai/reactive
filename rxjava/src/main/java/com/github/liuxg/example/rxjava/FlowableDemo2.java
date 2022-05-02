package com.github.liuxg.example.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;

/**
 * @author xinguai.liu
 */
public class FlowableDemo2 {

    public static void main(String[] args) {
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<String> emitter) throws Throwable {
                emitter.onNext("1");
                Thread.sleep(1000);
                if (emitter.isCancelled()) {
                    return;
                }
                emitter.onNext("2");
                Thread.sleep(1000);
                emitter.onComplete();
            }
        }, BackpressureStrategy.BUFFER)
                .subscribe(value -> System.out.printf("%s receive : %s%n", Thread.currentThread().getName(), value));
        System.out.println(Thread.currentThread().getName() + "Done!");
    }
}
