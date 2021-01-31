package org.acme.randomString;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

@Path("/randomString")
public class RandomStringResource{
	
    private static final Logger logger = Logger.getLogger(RandomStringResource.class);
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRandomString() {
    	RandomStringResponseVO randomStringResponse = new RandomStringResponseVO();
    	
    	Response response = Response
    		.status( Response.Status.OK )
    		.entity( randomStringResponse )
    		.build();
    	
    	logger.infof("Response to /randomString with %s", randomStringResponse.getRandomString());
    	
    	return response;
    }//getRandomString

}//RandomStringResource