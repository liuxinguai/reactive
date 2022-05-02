package com.github.liuxg.example.webflux.config;

import com.github.liuxg.example.webflux.handler.UserEntity;
import com.github.liuxg.example.webflux.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.method.RequestMappingInfo;
import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerMapping;

/**
 * @author xinguai.liu
 */
@EnableWebFlux
@Configuration
public class WebConfig implements WebFluxConfigurer {

    @Bean
    public RouterFunction<ServerResponse> testFunRouterFunction() {
        RouterFunction<ServerResponse> route = RouterFunctions.route(RequestPredicates.path("/testfun"),
                request -> ServerResponse.ok().body(BodyInserters.fromValue("hello")));
        return route;
    }

    @Autowired
    public void setHandlerMapping(RequestMappingHandlerMapping mapping, UserHandler userHandler) throws NoSuchMethodException {
        mapping.registerMapping(
                RequestMappingInfo.paths("/user/{id}").methods(RequestMethod.GET).build(),
                userHandler,userHandler.getClass().getMethod("getUser",String.class)
        );
        RequestMappingInfo.Builder builder = RequestMappingInfo.paths("/user").headers("Content-Type=application/json").methods(RequestMethod.POST);
        RequestMappingInfo info = builder.build();
        mapping.registerMapping(info,
                userHandler,userHandler.getClass().getMethod("add", UserEntity.class));
    }

}
