package org.acme.httpResponseStatusCode;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

@Path("/httpResponseStatusCode")
public class HttpResponseStatusCodeResource{
	
    private static final Logger logger = Logger.getLogger(HttpResponseStatusCodeResource.class);
	
    @GET
    @Path("/{httpResponseStatusCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEnvironmentVariable(@PathParam(value = "httpResponseStatusCode") Integer httpResponseStatusCode){
    	Response response = Response
    		.status( httpResponseStatusCode )
    		.build();
    	
    	logger.infof("Response to /httpResponseStatusCode %d", httpResponseStatusCode);
    	
    	return response;
    }//getRandomString

}//RandomStringResource