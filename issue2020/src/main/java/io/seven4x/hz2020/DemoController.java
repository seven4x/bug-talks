package io.seven4x.hz2020;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class DemoController {
    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping("/")
    public Map<String, Object> validate(String qrCode) {
        logger.debug("模拟请求校验：{}", qrCode);
        String s = UUID.randomUUID().toString();
        logger.debug("模拟任意输出{}", s);
        Map<String, Object> result = new HashMap<>();
        result.put(s, qrCode);
        return result;
    }
}
