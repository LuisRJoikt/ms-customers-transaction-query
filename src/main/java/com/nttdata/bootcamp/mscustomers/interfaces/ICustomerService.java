package com.nttdata.bootcamp.mscustomers.interfaces;


import com.nttdata.bootcamp.mscustomers.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService {
	
    public Mono<Customer> createCustomer(Mono<Customer> customer);
    public Mono<Customer> updateCustomer(Mono<Customer> customer);
    
    
    public void deleteCustomer(Integer id);
   // public Mono<Customer> updateCustomer(Customer customer);
    
    public Flux<Customer> findAllCustomers();
    public Flux<Customer> findcustomerAccount(String accNum);
	
	
    


    
}
