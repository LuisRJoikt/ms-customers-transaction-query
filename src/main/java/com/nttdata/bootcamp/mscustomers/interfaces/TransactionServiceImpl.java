package com.nttdata.bootcamp.mscustomers.interfaces;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.mscustomers.infraestructure.ITransactionRepository;
import com.nttdata.bootcamp.mscustomers.model.Transaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements ITransactionService {
    @Autowired
    private ITransactionRepository repository;

    @Override
    public Mono<Transaction> createTransaction(Mono<Transaction> transaction) {
        return transaction.flatMap(repository::insert);
    }

    @Override
    public Mono<Transaction> updateTransaction(Transaction transaction) {
        return repository.findById(transaction.getId())
                .map(t -> transaction).flatMap(repository::save);
    }

    @Override
    public Flux<Transaction> findAllTransaction() {
        return repository.findAll();
    }

    @Override
    public Optional<Mono<Transaction>> findTransactionByNroAccount(String nroAccount) {
        return repository.findByNroAccount(nroAccount);
    }

    @Override
    public void deleteTransaction(String id) {
        repository.deleteById(id);
    }

    @Override
    public Mono<Transaction> findTransactionById(String id) {
        return repository.findById(id);
    }

}
