package com.nttdata.bootcamp.mscustomers.infraestructure;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


import com.nttdata.bootcamp.mscustomers.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ICustomerRepository extends ReactiveMongoRepository<Customer,Integer>{
    public Flux<Customer> findByAccNum(String accNum);

	/*public Mono<Customer> save(Mono<Customer> customer);
	public Mono<Customer> createCustomer(Mono<Customer> customer);*/

	
}
