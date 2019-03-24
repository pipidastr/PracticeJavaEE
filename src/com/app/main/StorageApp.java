package com.app.main;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/app")
public class StorageApp extends Application{
    
    private Set<Object> singletons = new HashSet<Object>();
    
    public StorageApp() {
        singletons.add(new Hello());
    }
 
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
