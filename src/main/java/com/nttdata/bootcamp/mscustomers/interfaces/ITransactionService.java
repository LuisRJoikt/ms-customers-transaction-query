package com.nttdata.bootcamp.mscustomers.interfaces;

import java.util.Optional;

import com.nttdata.bootcamp.mscustomers.model.Transaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionService {
    public Mono<Transaction> createTransaction(Mono<Transaction> transaction);

    public Mono<Transaction> updateTransaction(Transaction transaction);

    public Flux<Transaction> findAllTransaction();

    public Optional<Mono<Transaction>> findTransactionByNroAccount(String nroAccount);

    public void deleteTransaction(String id);

    public Mono<Transaction> findTransactionById(String id);
}
