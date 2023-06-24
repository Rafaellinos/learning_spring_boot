package com.example.utils;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // create a bean every injection
public class PrintSomething {

    public PrintSomething() {
        System.out.println("inicializing " + getClass().getName());
    }

    public void pprintSomething(String something) {
        if (something == null) {
            something = "nada";
        }
        System.out.println(something);
    }
}
