package com.bitseatech.schedulerx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    MyDemoMapReducerProcess myDemoMapReducerProcess;
    @RequestMapping("/test")
    public String test(){
         return myDemoMapReducerProcess.toString();
    }
}
