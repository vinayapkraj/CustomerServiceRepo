package com.alten.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alten.dto.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer>{
	public Customer findByCustomerID(int custID);
}