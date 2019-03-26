package com.app.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.main.Consumer;
import com.app.main.Order;
import com.app.main.OrderProduct;
import com.app.main.Product;
import com.app.main.Provider;

public class MySQLQuery {
    
    private MySQLconnectorModel connectorModel = new MySQLconnectorModel("admin", "admin", "localhost", "3306", "storage");
    private ResultSet resultSet = null;
    private Statement statement = null;
    
    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    
    public MySQLconnectorModel getConnectorModel() {
        return connectorModel;
    }

    public void setConnectorModel(MySQLconnectorModel connectorModel) {
        this.connectorModel = connectorModel;
    }
    
    public void prepareQuery(String query) {
        try(Connection conn = MySQLconnector.getConnection(connectorModel)){
            
            PreparedStatement pst = conn.prepareStatement(query);
            pst.executeUpdate();
            
            }catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
        }
    }
    
    public List<Object> getResultQuery(String query) {
        
        try(Connection conn = MySQLconnector.getConnection(connectorModel)){
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            return getListFromResaultSET(resultSet);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Object> getListFromResaultSET(ResultSet resultSet) throws SQLException {
        String shemaName = resultSet.getMetaData().getTableName(1);
        
        switch (shemaName) {
            case "providers":{
                List<Object> providerList = new ArrayList<>();
                
                while(resultSet.next()) {
                    providerList.add(new Provider(resultSet.getInt("ID"), resultSet.getString("provider_name")));
                }
                return providerList;
            }
            
            case "products":{
                List<Object> productList = new ArrayList<>();
                
                while(resultSet.next()) {
                    productList.add(new Product(resultSet.getInt("ID"), resultSet.getString("product_name"), 
                            resultSet.getInt("product_provider_ID"), resultSet.getDouble("product_price"), 
                            resultSet.getInt("product_count")));
                }
                return productList;
            }
            
            case "consumers":{
                List<Object> consumersList = new ArrayList<>();
                
                while(resultSet.next()) {
                    consumersList.add(new Consumer(resultSet.getInt("ID")));
                }
                return consumersList;
            }
            
            case "order":{
                List<Object> orderList = new ArrayList<>();
                
                while(resultSet.next()) {
                    orderList.add(new Order(resultSet.getInt("ID"), resultSet.getInt("consumer_ID")));
                }
                return orderList;
            }
            
            case "order_product":{
                List<Object> orderProductList = new ArrayList<>();
                
                while(resultSet.next()) {
                    orderProductList.add(new OrderProduct(resultSet.getInt("ID"), resultSet.getInt("product_ID"),
                            resultSet.getInt("order_product_count")));
                }
                return orderProductList;
            }
            
            default:{
                return null;
            }
        } 
    }

}
