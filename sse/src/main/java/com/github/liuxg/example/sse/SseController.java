package com.github.liuxg.example.sse;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @author xinguai.liu
 */
@RequestMapping("/sse")
@RestController
public class SseController {


    @GetMapping("connect/{id}")
    public SseEmitter connect(@PathVariable("id") String id) {
        return SseService.connect(id);
    }

    @GetMapping("push/{message}")
    public ResponseEntity<String> push(@PathVariable("message") String message) {
        SseService.batchSend(message);
        return ResponseEntity.ok("推送消息给所有人..");
    }

    @GetMapping("close/{id}")
    public ResponseEntity<String> close(@PathVariable("id") String id) {
        SseService.disConnection(id);
        return ResponseEntity.ok(id);
    }




}
