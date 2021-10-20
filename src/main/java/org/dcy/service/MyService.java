package org.dcy.service;

import java.util.concurrent.ExecutorService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

@ApplicationScoped
public class MyService {

    final ExecutorService threadPool;
    final Logger log;

    @Inject
    MyService(ExecutorService threadPool, Logger log) {
        this.threadPool = threadPool;
        this.log = log;
    }

    public String doSomething(String input) {
        log.infov("received input {}", input);
        return input.toUpperCase();
    }

    public void execute() {
        for (int i = 0; i < 10; i++) {
            threadPool.submit(() -> {
                log.info("i am currently working on something");
            });
        }
    }
}
