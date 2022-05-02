package com.github.liuxg.example.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;


public class ThrottleGatewayFilter implements GatewayFilter {


    int capacity;

    int refillTokens;

    int refillPeriod;

    TimeUnit refillUnit;

    public int getCapacity() {
        return capacity;
    }

    public ThrottleGatewayFilter setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public int getRefillTokens() {
        return refillTokens;
    }

    public ThrottleGatewayFilter setRefillTokens(int refillTokens) {
        this.refillTokens = refillTokens;
        return this;
    }

    public int getRefillPeriod() {
        return refillPeriod;
    }

    public ThrottleGatewayFilter setRefillPeriod(int refillPeriod) {
        this.refillPeriod = refillPeriod;
        return this;
    }

    public TimeUnit getRefillUnit() {
        return refillUnit;
    }

    public ThrottleGatewayFilter setRefillUnit(TimeUnit refillUnit) {
        this.refillUnit = refillUnit;
        return this;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
        return exchange.getResponse().setComplete();
    }

}
