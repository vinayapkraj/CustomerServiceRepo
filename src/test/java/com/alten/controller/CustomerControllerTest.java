package com.alten.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.mockito.BDDMockito.given;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.core.Is.is;

import com.alten.controller.CustomerController;
import com.alten.dto.Customer;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
	
	 @Autowired
	   private MockMvc mvc;
	 
	 @MockBean
	 	private CustomerController customerController;

	@Test
    public void addCustomer() throws Exception{
    	
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/addCustomer").accept(
				MediaType.APPLICATION_JSON);
    	mvc.perform(requestBuilder).andExpect(status().isOk());
        
    }
	
	@Test
	public void getCustomerByIDTest() throws Exception {
		Customer customer = new Customer(123,"Test","Test");
			
    	given(customerController.getCustomer(customer.getCustomerID())).willReturn(customer);
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/getCustomerDetails/123").accept(
				MediaType.APPLICATION_JSON);
    	mvc.perform(requestBuilder).andExpect(status().isOk())
    	.andExpect(jsonPath("customerID", is(customer.getCustomerID())));
        
    }
}