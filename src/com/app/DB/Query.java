package com.app.DB;

public class Query {

    private String select;
    private String delete;
    private String insert;
    private String update;
    
    public String getSelect() {
        return select;
    }
    public void setSelect(String select) {
        this.select = select;
    }
    public String getDelete() {
        return delete;
    }
    public void setDelete(String delete) {
        this.delete = delete;
    }
    public String getInsert() {
        return insert;
    }
    public void setInsert(String insert) {
        this.insert = insert;
    }
    public String getUpdate() {
        return update;
    }
    public void setUpdate(String update) {
        this.update = update;
    }
    
    public String selectExpression(String table) {
        this.select = "SELECT * FROM storage." + table;
        return select;
    }
    
    public String deleteExpression(String table, String ID) {
        this.delete = "DELETE FROM `storage`.`" + table +"` WHERE (`ID` = '" + ID +"')";
        return delete;
    }
    
    public String updateProvider(int ID, String providerName) {
        this.select = "UPDATE `storage`.`providers` SET `provider_name` = '" + providerName + "' WHERE (`ID` = '" + ID +"')";
        return select;
    }
    
    public String updateProduct(int ID, String productName, int productCount, double productPrice, int productProviderID) {
        this.update = "UPDATE `storage`.`products` SET `product_name` = '" + productName + "', `product_count` = '" + productCount 
                + "', `product_price` = '" + productPrice + "', `product_provider_ID` = '" + productProviderID + "' WHERE (`ID` = '" + ID + "')";
        return update;
    }
    
    public String updateProductCount(int ID, int purchased—ount) {
        this.update = "UPDATE `storage`.`products` SET `product_count` = `product_count` - " + purchased—ount + " WHERE (`ID` = '" + ID + "')";
        return update;
    }
    
    public String updateConsumer(int ID, String consumerName) {
        this.select = "UPDATE `storage`.`consumers` SET `consumer_name` = '" + consumerName + "' WHERE (`ID` = '" + ID +"')";
        return update;
    }
    
    public String updateOrder(int ID, int consumerID) {
        this.update = "UPDATE `storage`.`order` SET `consumer_ID` = '" + consumerID + "' WHERE (`ID` = '" + ID + "')";
        return update;
    }
    
    public String updateOrderProduct(int ID, int productID, int productCount) {
        this.update = "UPDATE `storage`.`order_product` SET `product_ID` = '" + productID + "', `order_product_count` = '" + productCount
                + "' WHERE (`ID` = '" + ID + "')";
        return update;
    }
    
    
    
    public String insertProduct(String productName, int productCount, double productPrice, int productProviderID) {
        this.insert = "INSERT INTO `storage`.`products` (`product_name`, `product_count`, `product_price`, `product_provider_ID`) VALUES ('" 
                + productName + "', '" + productCount + "', '" + productPrice + "', '" + productProviderID + "')";
        return insert;
    }
    
    public String insertProvider(String providerName) {
        this.insert = "INSERT INTO `storage`.`providers` (`provider_name`) VALUES ('" + providerName + "')";
        return insert;
    }
    
    public String insertConsumer() {
        this.insert = "INSERT INTO `storage`.`consumers` (`consumer_name`) VALUES (NULL)";
        return insert;
    }
    
    public String insertConsumer(String consumerName) {
        this.insert = "INSERT INTO `storage`.`consumers` (`consumer_name`) VALUES ('" + consumerName + "')";
        return insert;
    }
    
    public String insertOrder(int consumerID) {
        this.insert = "INSERT INTO `storage`.`order` (`consumer_ID`) VALUES ('" + consumerID + "')";
        return insert;
    }
    
    public String insertOrderProduct(int orderID, int productID, int productCount) {
        this.insert = "INSERT INTO `storage`.`order_product` (`ID`, `product_ID`, `order_product_count`) VALUES ('" + orderID + "', '" + productID + "', '" + productCount + "')";
        return insert;
    }
    
}
