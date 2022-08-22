package org.quarkus.bff;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.springframework.stereotype.Repository;

@Repository
@ApplicationScoped
public class CustRepository {
	
	static Map<String, Customer> customerDetails = new HashMap<String, Customer>();
	
    public List<Customer> all() throws SQLDataException {
        return new ArrayList<>(customerDetails.values());
    }
    public Customer getById(String id) {
        return customerDetails.get(id);
    }
    public Customer save(Customer customer) {
    	customerDetails.put(customer.getCustId(), customer);
        return customer;
    }
    public void deleteById(String id) {
    	customerDetails.remove(id);
    }

}
