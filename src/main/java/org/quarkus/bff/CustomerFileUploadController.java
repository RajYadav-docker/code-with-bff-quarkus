package org.quarkus.bff;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Path("/upload")
@RequestScoped
public class CustomerFileUploadController {
	
	@Inject
    FileUploadService fileUploadService;

	@POST
	@Path("/files")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public Response fileUpload(@MultipartForm MultipartFormDataInput input) {
		System.out.println("inside controller"+input.getParts());
		return Response.ok().entity(fileUploadService.uploadFile(input)).build();
	}

}
