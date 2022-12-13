package com.example.sentinel.feign;
 
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
 
@FeignClient(name = "springcloud-sentinel", path = "/hello", fallback = ServiceFailFeign.class)
public interface Service1HelloInterface {
    @GetMapping("/error")
    String error();
}