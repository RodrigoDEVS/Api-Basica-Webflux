package com.example.demo.repositories;

import com.example.demo.collections.Dato;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface Repositorio extends ReactiveMongoRepository<Dato, String> {
}
