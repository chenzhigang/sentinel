package com.example.sentinel.feign;
 
import org.springframework.stereotype.Component;
 
@Component
public class ServiceFailFeign implements Service1HelloInterface{
    public String error() {
        return "降级了！！！";
    }
}