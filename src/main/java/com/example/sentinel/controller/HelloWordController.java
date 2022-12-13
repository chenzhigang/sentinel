package com.example.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWordController {

    @SentinelResource(value = "helloWorld", blockHandler = "helloWorldBlock")
    @GetMapping("/world")
    public String helloWorld() {
        return "Hello World !";
    }

    public String helloWorldBlock(BlockException blockException) {
        return "你被流控啦，憨憨";
    }

    @SentinelResource(value = "letGo")
    @GetMapping("/letGo")
    public String letGo() {
        return "let go !";
    }

    @SentinelResource(value = "error")
    @GetMapping("/error")
    public String error() {
        int i = 1/0;
        return "do error !";
    }
}
