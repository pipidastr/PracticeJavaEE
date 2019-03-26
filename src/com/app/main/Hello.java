package com.app.main;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.app.DB.MySQLQuery;

@Path("/main")
public class Hello{
    
    MySQLQuery mySQLQuery = new MySQLQuery();
    String query;

    @GET
    @Path("/get/list/{table}")
    @Produces("application/json")
    public Response getList(@PathParam("table") String table) {
        query = "SELECT * FROM storage." + table;
        return Response.status(200).entity(mySQLQuery.getResultQuery(query)).build();
    }
    
    @DELETE
    @Path("/delete/{table}/{id}")
    @Produces("application/json")
    public Response deleteFromShema(@PathParam("table") String table,@PathParam("id") String id) {
        query = "DELETE FROM `storage`.`" + table +"` WHERE (`ID` = '" + id +"')";
        mySQLQuery.prepareQuery(query);
        
        query = "SELECT * FROM storage." + table;
        return Response.status(200).entity(mySQLQuery.getResultQuery(query)).build();
    }
    
    @POST
    @Path("/add/provider")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addProvider(Provider provider) {
        query = "INSERT INTO `storage`.`providers` (`provider_name`) VALUES ('" + provider.getName() +"')";
        mySQLQuery.prepareQuery(query);
        
        query = "SELECT * FROM storage.providers";
        return Response.status(200).entity(mySQLQuery.getResultQuery(query)).build();
    }
    
    @PUT
    @Path("/put/provider/{ID}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response putProvider(Provider provider, @PathParam("ID") int ID) {
        query = "UPDATE `storage`.`providers` SET `provider_name` = '" + provider.getName() + "' WHERE (`ID` = '" + ID +"')";
        mySQLQuery.prepareQuery(query);
        
        query = "SELECT * FROM storage.providers";
        return Response.status(200).entity(mySQLQuery.getResultQuery(query)).build();
    }
}
