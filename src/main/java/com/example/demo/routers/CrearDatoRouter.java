package com.example.demo.routers;

import com.example.demo.dto.DatoDTO;
import com.example.demo.usecases.UseCaseCrear;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public class CrearDatoRouter {

    @Bean
    public RouterFunction<ServerResponse> createQuestion(UseCaseCrear useCaseCrear){
        return route(POST("/crear").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(DatoDTO.class)
                        .flatMap(questionDTO -> useCaseCrear.apply(questionDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.TEXT_PLAIN)
                                        .bodyValue(result))));
    }
}
