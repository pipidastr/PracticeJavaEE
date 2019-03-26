package com.app.DB;

public class MySQLconnectorModel {
    
    private String userName;
    private String password;
    private String host;
    private String port;
    private String DBShema;
    private String connString;
    
    public MySQLconnectorModel(String userName, String password, String host, String port, String dBShema) {
        this.userName = userName;
        this.password = password;
        this.host = host;
        this.port = port;
        DBShema = dBShema;
        connString = "jdbc:mysql://" + host + ":" + port + "/" +dBShema +
                "?verifyServerCertificate=false"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC";;
    }
    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public String getDBShema() {
        return DBShema;
    }
    public void setDBShema(String dBShema) {
        DBShema = dBShema;
    }
    public String getConnString() {
        return connString;
    }
    public void setConnString(String connString) {
        this.connString = connString;
    }
}
