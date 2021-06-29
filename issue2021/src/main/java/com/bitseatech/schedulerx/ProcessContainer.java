package com.bitseatech.schedulerx;

import com.alibaba.schedulerx.worker.processor.JavaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class ProcessContainer {

    List<JavaProcessor> process;

    @Autowired
    public void test(List<JavaProcessor> process) {
        this.process = process;
    }

    @PostConstruct
    public void afterSetting() {
        for (JavaProcessor p : process) {
            System.out.println(p.toString());
        }
    }
}
