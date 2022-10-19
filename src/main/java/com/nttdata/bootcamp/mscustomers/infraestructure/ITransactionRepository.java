package com.nttdata.bootcamp.mscustomers.infraestructure;

import java.util.Optional;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bootcamp.mscustomers.model.Transaction;

import reactor.core.publisher.Mono;

@Repository
public interface ITransactionRepository extends ReactiveMongoRepository<Transaction, String> {
    public Optional<Mono<Transaction>> findByNroAccount(String nroAccount);
}
