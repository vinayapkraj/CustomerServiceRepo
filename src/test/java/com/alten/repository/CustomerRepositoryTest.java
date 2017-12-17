package com.alten.repository;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import com.alten.dto.Customer;
import com.alten.repository.CustomerRepository;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class CustomerRepositoryTest {
	 	@Autowired
	    public TestEntityManager entityManager;

	    @Autowired
	    CustomerRepository customerRepo;

	    @Test
	    public void findByCustomerAddress() {
	        Customer customer = new Customer(123,"Testing Vehicle","Test Address");
//	        vehicle.setVehicleID("Test vehicle ID");
//	        vehRepos.save(vehicle);
	        entityManager.persist(customer);
	        entityManager.flush();

	        Customer findByCustomerID = customerRepo.findByCustomerID(customer.getCustomerID());

	        assertThat(findByCustomerID).isEqualTo(customer);
	    }

}