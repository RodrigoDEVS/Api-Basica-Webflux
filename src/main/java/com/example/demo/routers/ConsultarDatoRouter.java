package com.example.demo.routers;

import com.example.demo.dto.DatoDTO;
import com.example.demo.usecases.UseCaseListar;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public class ConsultarDatoRouter {

    @Bean
    public RouterFunction<ServerResponse> getAll(UseCaseListar useCaseListar){
        return route(GET("/consultar").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCaseListar.get(), DatoDTO.class)));
    }
}
