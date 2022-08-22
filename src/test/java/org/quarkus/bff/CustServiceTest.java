package org.quarkus.bff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class CustServiceTest {
	
	@Inject
	CustService custService;
	
	
	@InjectMock
	CustRepository custRepository;
	
	List<Customer> custList=new ArrayList<>();
	Customer cust1=new Customer();
	Customer cust2=new Customer();
	
	@BeforeEach
	public void setup() {
		cust1.setCustId(UUID.randomUUID().toString());
		cust1.setCustFirstName("Ramesh");
		cust1.setCustLastName("Yadav");
		cust1.setCustDOB("01/06/1985");
		cust2.setCustId(UUID.randomUUID().toString());
		cust2.setCustFirstName("Rakesh");
		cust2.setCustLastName("Pandey");
		cust2.setCustDOB("01/06/1987");
		custList.add(cust1);
		custList.add(cust2);
	}
	
    @Test
    public void testGetCustomer_fetchAllCustomerDetails() throws SQLDataException {
    	when(custRepository.all()).thenReturn(custList);
    	assertNotNull(custService.getCustomer());
    	assertEquals(2, custService.getCustomer().size());
    	
    }
    
    @Test
    public void testGetCustomer_ThrowsException() throws SQLDataException {
    	when(custRepository.all()).thenThrow(SQLDataException.class);
    	Exception exception = assertThrows(SQLDataException.class, () ->custService.getCustomer());
        assertEquals("Exception occurred while communicating with database", exception.getMessage());
    	
    }
    
    @Test
    public void testGetCustomerById() {
    	when(custRepository.getById(anyString())).thenReturn(cust1);
    	assertNotNull(custService.getCustomerById("ac5ee2b3-9f26-4e31-98e3-3f666c82ac60"));
    	
    }
    
    @Test
    public void testSaveCustomer() {
    	when(custRepository.save(cust1)).thenReturn(cust1);
    	assertNotNull(custService.saveCustomer(cust1));
    	
    }
	
}
