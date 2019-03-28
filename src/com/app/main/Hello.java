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
import com.app.DB.Query;
import com.app.model.Consumer;
import com.app.model.Order;
import com.app.model.OrderProduct;
import com.app.model.Product;
import com.app.model.Provider;

@Path("/main")
public class Hello{
    
    MySQLQuery mySQLQuery = new MySQLQuery();
    Query query = new Query();

    @GET
    @Path("/get/list/{table}")
    @Produces("application/json")
    public Response getList(@PathParam("table") String table) {
        return Response.status(200).entity(mySQLQuery.getResultQuery(query.selectExpression(table))).build();
    }
    
    @DELETE
    @Path("/delete/{table}/{ID}")
    @Produces("application/json")
    public Response deleteFromShema(@PathParam("table") String table,@PathParam("ID") String ID) {
        mySQLQuery.prepareQuery(query.deleteExpression(table, ID));
        return Response.status(200).entity("DONE").build();
    }
    
    @POST
    @Path("/post/provider")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addProvider(Provider provider) {
        mySQLQuery.prepareQuery(query.insertProvider(provider.getName()));
        return Response.status(200).entity("DONE").build();
    }
    
    @POST
    @Path("/post/product")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addProduct(Product product) {
        mySQLQuery.prepareQuery(query.insertProduct(product.getName(), product.getCount(), product.getPrice(), product.getProviderID()));
        return Response.status(200).entity("DONE").build();
    }
    
    @POST
    @Path("/post/consumer")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addConsumer(Consumer consumer) {
        mySQLQuery.prepareQuery(query.insertConsumer(consumer.getName()));
        return Response.status(200).entity("DONE").build();
    }
    
    @POST
    @Path("/post/order")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addOrder(Order order) {
        mySQLQuery.prepareQuery(query.insertOrder(order.getConsumerID()));
        return Response.status(200).entity("DONE").build();
    }
    
    @POST
    @Path("/post/order_product")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addOrderProduct(OrderProduct orderProduct) {
        mySQLQuery.prepareQuery(query.updateProductCount(orderProduct.getProductID(), orderProduct.getCount()));
        mySQLQuery.prepareQuery(query.insertOrderProduct(orderProduct.getID(), orderProduct.getProductID(), orderProduct.getCount()));
        return Response.status(200).entity("DONE").build();
    }
    
    @PUT
    @Path("/put/provider")
    @Produces("application/json")
    @Consumes("application/json")
    public Response putProvider(Provider provider) {
        mySQLQuery.prepareQuery(query.updateProvider(provider.getID(), provider.getName()));
        return Response.status(200).entity("DONE").build();
    }
    
    @PUT
    @Path("/put/product")
    @Produces("application/json")
    @Consumes("application/json")
    public Response putProduct(Product product) {
        mySQLQuery.prepareQuery(query.updateProduct(product.getID(), product.getName(), product.getCount(), product.getPrice(), product.getProviderID()));
        return Response.status(200).entity("DONE").build();
    }
    
    @PUT
    @Path("/put/consumer")
    @Produces("application/json")
    @Consumes("application/json")
    public Response putConsumer(Consumer consumer) {
        mySQLQuery.prepareQuery(query.updateConsumer(consumer.getID(), consumer.getName()));
        return Response.status(200).entity("DONE").build();
    }
    
    @PUT
    @Path("/put/order")
    @Produces("application/json")
    @Consumes("application/json")
    public Response putOrder(Order order) {
        mySQLQuery.prepareQuery(query.updateOrder(order.getID(), order.getConsumerID()));
        return Response.status(200).entity("DONE").build();
    }
    
    @PUT
    @Path("/put/order_product")
    @Produces("application/json")
    @Consumes("application/json")
    public Response putOrderProduct(OrderProduct orderProduct) {
        mySQLQuery.prepareQuery(query.updateOrderProduct(orderProduct.getID(), orderProduct.getProductID(), orderProduct.getCount()));
        return Response.status(200).entity("DONE").build();
    }
}
