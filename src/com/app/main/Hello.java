package com.app.main;

import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/main")
public class Hello{

    @GET
    @Path("/hello")
    public Response hello() {
        return Response.status(200).entity("hello").build();
       
    }
    
    @GET
    @Path("/list")
    @Produces("application/json")
    public Product getProductsList() {
        Provider provider = new Provider("Coca-cola");
        Product product = new Product("Coca-Cola ZERO", 89.99, 100, provider);
        return product;
    }
    
    @GET
    @Path("/{id}")
    public Response getString(@PathParam("id") String id) {
        return Response.status(200).entity("number " + id).build();
    }
}
