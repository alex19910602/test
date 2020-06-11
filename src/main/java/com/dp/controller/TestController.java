package com.dp.controller;

import com.dp.config.LogAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author jacob.deng
 * @Date 2020-05-19 15:52
 */
@RestController
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping(value = "/a")
    public Object a (@RequestParam(required = false) String s) {

        logger.info("=====:{}", s);
        return null;
    }
}
