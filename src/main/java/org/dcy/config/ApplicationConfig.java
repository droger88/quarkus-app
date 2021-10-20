package org.dcy.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.dcy.domain.Name;

@ApplicationScoped
public class ApplicationConfig {
    
    @Produces
    Name name(){
        return new Name("produce","bean");
    }

    @Produces
    ExecutorService threadPool(){
        return Executors.newFixedThreadPool(10); 
    }
}
