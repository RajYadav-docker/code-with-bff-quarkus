package org.quarkus.bff;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/singlesearch/")
@Produces(MediaType.APPLICATION_JSON)
//@RegisterRestClient(baseUri = "https://api.tvmaze.com/")
@RegisterRestClient
public interface TVSeriesService {
	
	@GET
	@Path("/shows")
	TVSeries getMovieDetails(@QueryParam("q") String title);

}
