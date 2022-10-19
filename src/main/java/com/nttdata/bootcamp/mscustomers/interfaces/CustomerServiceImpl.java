package com.nttdata.bootcamp.mscustomers.interfaces;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.nttdata.bootcamp.mscustomers.infraestructure.ICustomerRepository;

import com.nttdata.bootcamp.mscustomers.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository repository;

    @Override
    public Mono<Customer> createCustomer(Mono<Customer> customer) {
        return customer.flatMap(repository::insert);
    }
    @Override
    public Mono<Customer> updateCustomer(Mono<Customer> customer) {
        return customer.flatMap(repository::save);
    }
    @Override
    public void deleteCustomer(Integer id) {
        //customer.flatMap(repository::delete);
    	repository.deleteById(id);
    }
    
  
    @Override
    public Flux<Customer> findAllCustomers() {     
    	 return repository.findAll(); 
    }
   
    @Override
    public Flux<Customer> findcustomerAccount(String accNum) {
       	 return repository.findByAccNum(accNum);    	 
    }
}
