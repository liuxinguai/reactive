package com.github.liuxg.example.rxjava;

import io.reactivex.rxjava3.core.Observable;

/**
 * @author xinguai.liu
 */
public class ObservableDemo2 {

    public static void main(String[] args) {
        Observable.create(emitter -> {
            while (!emitter.isDisposed()) {
                final long now = System.currentTimeMillis();
                emitter.onNext(now);
                if (now % 2 == 0) {
                    emitter.onError(new IllegalStateException("even millisecond"));
                    break;
                }
            }
        }).subscribe(System.out::println,Throwable::printStackTrace);
    }

}
