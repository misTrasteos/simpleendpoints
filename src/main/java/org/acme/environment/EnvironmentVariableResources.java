package org.acme.environment;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

@Path("/environmentVariable")
public class EnvironmentVariableResources{
	
    private static final Logger logger = Logger.getLogger(EnvironmentVariableResources.class);
	
    @GET
    @Path("/{environmentVariableName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEnvironmentVariable(@PathParam(value = "environmentVariableName") String environmentVariableName){
    	EnvironmentVariableResponseVO environmentVariableResponse = new EnvironmentVariableResponseVO(environmentVariableName);
    	
    	Response response = Response
    		.status( Response.Status.OK )
    		.entity( environmentVariableResponse )
    		.build();
    	
    	logger.infof("Response to /environmentVariable/%s with %s", environmentVariableName, environmentVariableResponse.getRandomString());
    	
    	return response;
    }//getRandomString

}//RandomStringResource