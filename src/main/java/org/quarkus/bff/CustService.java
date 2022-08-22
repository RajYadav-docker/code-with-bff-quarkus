package org.quarkus.bff;

import java.sql.SQLDataException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustService {
	
	
	@Autowired
    CustRepository custRepo;
    
    public Customer saveCustomer(Customer customer) {
        Customer savedCustomer = this.custRepo.save(customer);
        return savedCustomer;
    }
    
    public List<Customer> getCustomer() throws SQLDataException{
        List<Customer> allCust=null;
		try {
			allCust = this.custRepo.all();
		} catch (Exception ex) {
			String errMsg="Exception occurred while communicating with database";
			throw new SQLDataException(errMsg);
		}
        return allCust;
    }
    
    public Customer getCustomerById(String custId) {
        Customer cust = this.custRepo.getById(custId);
        return cust;
    }

    public void delCustomerById(String custId) {
        this.custRepo.deleteById(custId);
    }

}