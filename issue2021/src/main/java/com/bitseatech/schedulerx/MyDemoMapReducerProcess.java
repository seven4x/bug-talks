package com.bitseatech.schedulerx;

import com.alibaba.fastjson.JSON;
import com.alibaba.schedulerx.worker.domain.JobContext;
import com.alibaba.schedulerx.worker.processor.MapReduceJobProcessor;
import com.alibaba.schedulerx.worker.processor.ProcessResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MyDemoMapReducerProcess extends MapReduceJobProcessor {
    final String level1 = "Task_Level_1";


    @Override
    public ProcessResult process(JobContext context) throws Exception {
        if (isRootTask(context)) {

            List<Integer> list = new ArrayList<>(10000);
            for (int i = 0; i < 10000; i++) {
                list.add(i);
            }
            map(list, level1);

            return new ProcessResult(true, "root done");
        } else if (context.getTaskName().equals(level1)) {
            int time = new Random().nextInt(1000);
            Thread.sleep(time);
            return new ProcessResult(true, time + "");
        }
        return new ProcessResult(true, "error");

    }

    @Override
    public ProcessResult reduce(JobContext context) throws Exception {
        String s = JSON.toJSONString(context.getTaskResults());
        System.out.println(s);
        return new ProcessResult(true, "reduce");
    }

}
