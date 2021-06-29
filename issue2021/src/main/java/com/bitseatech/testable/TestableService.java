package com.bitseatech.testable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestableService {
    @Autowired
    DependencyDao dao;

    //
    public String doBusiness() {
        String user = dao.getUser();
        return doInner(user);
    }
    public String doInner(String user){
        if ("Root".equals(user)) {
            System.out.println("do something");
            return "root";
        } else {
            //xxx 复杂的控制逻辑
            return "abc";
        }
    }
}
