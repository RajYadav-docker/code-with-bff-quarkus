package org.quarkus.bff;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.quarkus.bff.exceptionHandler.MoviesDetailsNotFoundException;
import org.quarkus.bff.exceptionHandler.UserIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestScoped
@RequestMapping("/customer")
public class BFFController {

	@Autowired
	CustService custService;

	@RestClient
	LoginService loginService;

	@RestClient
	TVSeriesService tvSeriesService;

	@GetMapping("/getCustomerDetails")
	public ResponseEntity<List<Customer>> allCustDetails() throws Exception {
		return new ResponseEntity<>(custService.getCustomer(), HttpStatus.OK);
	}
	
	@GetMapping("/greeting")
	public ResponseEntity<String> greeting() {
		return new ResponseEntity<>("Welcome to Quarkus Framework", HttpStatus.OK);
	}

	@GetMapping("/getCustomerDetails/byId")
	public ResponseEntity<Customer> getCustomerDetailsById(@RequestParam String custId) {
		return new ResponseEntity<>(custService.getCustomerById(custId), HttpStatus.OK);
	}

	@PostMapping("/new")
	public ResponseEntity<String> createCustomerDetails(@RequestBody Customer cust) {
		Customer customer = null;
		if (cust != null) {
			customer = custService.saveCustomer(cust);
		}
		return new ResponseEntity<>("New Customer Created Successfully with Id :" + customer.getCustId(),
				HttpStatus.CREATED);
	}

	@GetMapping("/getCustomerDetails/delById")
	public ResponseEntity<String> delCustomerById(@RequestParam String custId) {
		Optional<String> id = Optional.of(custId);
		if (id.isPresent()) {
			custService.delCustomerById(id.get());
		} else {
			throw new RuntimeException();
		}
		return new ResponseEntity<>("Existing Customer deleted Successfully with Id :" + custId, HttpStatus.CREATED);
	}

	@PostMapping("/loginDetails")
	public ResponseEntity<String> validateUser(@RequestBody Login login) throws UserIdNotFoundException,Exception {
		String token =null;
		try {
			token=loginService.validateUserLogin(login);
		if(token==null)
			throw new UserIdNotFoundException("User is not registered with system, please register first");
		
		}catch(Exception ex) {
			throw new Exception("Internal Server Error::"+ex.getMessage());
		}
		return new ResponseEntity<>("User Validate successfully and provide the token for authorization: " + token,
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/tvSeriesDetails") 
	public ResponseEntity<TVSeries> getTVSeries(@RequestParam("title") String title) throws MoviesDetailsNotFoundException,Exception {
		TVSeries tvSeries=null;
		try {
		if(title==null || title.isBlank()) {
			throw new MoviesDetailsNotFoundException("invalid title");
		}
		tvSeries=tvSeriesService.getMovieDetails(title);
		}catch(Exception mx) {
			throw new Exception("Movie details not found::"+mx.getMessage());
		}
		return new ResponseEntity<>(tvSeries, HttpStatus.OK);
	}

}
