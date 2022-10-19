package com.nttdata.bootcamp.mscustomers.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.mscustomers.interfaces.ITransactionService;
import com.nttdata.bootcamp.mscustomers.model.Transaction;
import com.nttdata.bootcamp.mscustomers.util.ValidatorUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TransactionController {
    @Autowired
    private ITransactionService service;

    @PostMapping
    public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction) {
        final Mono<Transaction> response = service.createTransaction(Mono.just(transaction));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<?> updateTransaction(@RequestBody Transaction transaction) {
        try {
            final Mono<Transaction> response = service.updateTransaction(transaction);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable String id, BindingResult result) {
        if (result.hasErrors()) {
            return ValidatorUtil.validate(result);
        }

        service.deleteTransaction(id);
        return ResponseEntity.ok("Transacción eliminada correctamente");
    }

    @GetMapping
    public ResponseEntity<?> findTransactions() {
        // if (result.hasErrors()) {
        // return ValidatorUtil.validate(result);
        // }

        final Flux<Transaction> response = service.findAllTransaction();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public Mono<?> findTransactionById(@PathVariable String id, BindingResult result) {
        if (result.hasErrors()) {
            return Mono.just(ValidatorUtil.validate(result));
        }

        return service.findTransactionById(id)
                .map(r -> ResponseEntity.ok(r))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
