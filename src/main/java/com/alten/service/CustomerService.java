package com.alten.service;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.alten.dto.Customer;
import com.alten.repository.CustomerRepository;

@Service
public class CustomerService{
	
	@Autowired
	private CustomerRepository custRepo;
	
	public static List<Customer> vehicleList = new ArrayList<Customer>();
	
	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		pushCustomerData();
	}
	
	public void pushCustomerData() {
		
		custRepo.save(new Customer(81,"Kalles Grustransporter AB","Cementvagen 8, 111 11 Sodertolje"));
		custRepo.save(new Customer(82,"Johans Bulk AB","Balkvagen 12, 222 22 Stockholm"));
		custRepo.save(new Customer(83,"Haralds Vardetransporter AB","Budgetvagen 1, 333 33 Uppsala"));
		
	}
	
	public Customer getCustomerByID(int custID){
		Customer custObj=custRepo.findByCustomerID(custID);
		return custObj;
		
	}
	
}