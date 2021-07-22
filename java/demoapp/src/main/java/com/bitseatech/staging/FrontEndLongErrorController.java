package com.bitseatech.staging;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FrontEndLongErrorController {

    @RequestMapping("/long-test")
    @ResponseBody
    public Map demo() {
        Map map = new HashMap();

        map.put("id", 18014398509481985L+"");
        map.put("id2",   Long.MAX_VALUE - 5);
        return map;
    }
}
