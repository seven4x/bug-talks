package com.bitseatech.staging.testable;

import org.springframework.stereotype.Component;

@Component
public class DependencyDao {

    public String getUser(){
        return "abc";
    }
}
