package com.github.liuxg.example.sse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.activation.MimeType;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xinguai.liu
 */
@Slf4j
public class SseService {

    private final static ConcurrentHashMap<String, SseEmitter> cache = new ConcurrentHashMap<>();



    public static AtomicInteger count = new AtomicInteger();

    public static SseEmitter connect(String userId) {
        SseEmitter sseEmitter = new SseEmitter();
        cache.put(userId,sseEmitter);
        count.incrementAndGet();
        log.info("创建sse连接，当前用户：{}",userId);
        sseEmitter.onCompletion(()->{
            log.info("结束连接：{}",userId);
            count.decrementAndGet();
            cache.remove(userId);
        });
        sseEmitter.onError(throwable->{
            log.error("连接异常",throwable);
            cache.remove(userId);
            count.decrementAndGet();
        });
        sseEmitter.onTimeout(()->{
            log.info("[{}]连接超时",userId);
            count.decrementAndGet();
            cache.remove(userId);
        });
        return sseEmitter;
    }

    public static void send(String userId, String message) {
        if (cache.containsKey(userId)) {
            try {
                cache.get(userId).send(message);
            } catch (IOException e) {
                log.error("推送消息异常！",e);
                count.decrementAndGet();
                cache.remove(userId);
            }
        }
    }

    public static void batchSend(String message) {
        cache.keySet().forEach(key->send(key,message));
    }

    public static void disConnection(String userId) {
        cache.remove(userId);
    }


}
