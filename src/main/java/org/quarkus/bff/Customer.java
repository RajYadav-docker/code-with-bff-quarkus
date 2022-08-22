package org.quarkus.bff;

import java.io.Serializable;
import java.util.UUID;

public class Customer implements Serializable {
	
	private static final long serialVersionUID = 8357540177805667745L;
	
	private String custId= UUID.randomUUID().toString();
    private String custFirstName;
    private String custLastName;
    private String custDOB;
    
    
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCustFirstName() {
		return custFirstName;
	}
	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}
	public String getCustLastName() {
		return custLastName;
	}
	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}
	public String getCustDOB() {
		return custDOB;
	}
	public void setCustDOB(String custDOB) {
		this.custDOB = custDOB;
	}
     
	
}
