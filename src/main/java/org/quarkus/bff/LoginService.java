package org.quarkus.bff;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface LoginService {
	
	@POST
	@Path("/login")
	String validateUserLogin(Login login);

}
