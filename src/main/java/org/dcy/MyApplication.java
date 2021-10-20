package org.dcy;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class MyApplication {
    
    public static void main(String[] args){
        System.out.println("starting the application");
        Quarkus.run(args);
    }
}
