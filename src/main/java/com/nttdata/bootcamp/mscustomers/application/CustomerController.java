package com.nttdata.bootcamp.mscustomers.application;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.mscustomers.enums.CustomerTypes;
import com.nttdata.bootcamp.mscustomers.interfaces.ICustomerService;

import com.nttdata.bootcamp.mscustomers.model.Customer;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
//@RequestMapping("customer")
public class CustomerController {
	    	    
	 
	 @Autowired	 
	 ICustomerService customerService;
	 
	
	 @GetMapping("customer") //(value = "customer",produces = MediaType.TEXT_EVENT_STREAM_VALUE)	 
	 public Flux<Customer>listarTodos() { 		 
		 return customerService.findAllCustomers();
	 }
	 @GetMapping("customer/findcustomerAccount/{accNum}")
	 public Flux<Customer>findcustomerAccount(@PathVariable("accNum") String accNum){
		// System.out.println("▓" + accNum);		 
		 return customerService.findcustomerAccount(accNum);		 
	 }
	
	 
	 
	 @PostMapping("customer")
	 Mono<Customer> createEmp(@RequestBody Customer customer){
		 return customerService.createCustomer(Mono.just(customer));
	 }
	 @PostMapping("customer/Update")
	 Mono<Customer> updateCustomer(@RequestBody Customer customer){
		 return customerService.updateCustomer(Mono.just(customer));
	 }
	 @DeleteMapping("customer/Delete/{id}")
	 ResponseEntity<?> deleteCustomer(@PathVariable Integer id){
		  customerService.deleteCustomer(id);
		  return ResponseEntity.ok().build();
	 }
	 
	 /*
	 @PostMapping("customer/Update")
	    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
	 System.out.println("▓" + customer);
		 Mono<Customer> response = customerService.updateCustomer(customer);
		 return ResponseEntity.ok(response);
		 */
	// Mono<Customer> updateCustomer(@RequestBody Customer customer){
	//	 return customerService.updateCustomer(Mono.just(customer));
	  
	 

}
