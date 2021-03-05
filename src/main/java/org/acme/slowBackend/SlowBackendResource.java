package org.acme.slowBackend;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

@Path("/slowBackend")
public class SlowBackendResource{
	
    private static final Logger logger = Logger.getLogger(SlowBackendResource.class);
	
    @GET
    @Path("/{delay}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEnvironmentVariable(@PathParam(value = "delay") Integer delay){
    	
    	Response response = null; 
    	
    	try {
			Thread.sleep(delay);
			
	    	response = Response
	            	.status( Response.Status.OK )
	            	.entity(delay)
	        		.build();
	    	
	    	logger.infof("Response to /slowBackend delayed %d milliseconds", delay);	    	
		}catch(InterruptedException e){
			logger.errorf("An error has ocurred while waiting, %s", e.getMessage());
		}
    	
    	return response;
    }//getRandomString

}//RandomStringResource