package com.example.demo.usecases;

import com.example.demo.dto.DatoDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface GuardarDato {
    public Mono<String> apply(DatoDTO datoDTO);
}
