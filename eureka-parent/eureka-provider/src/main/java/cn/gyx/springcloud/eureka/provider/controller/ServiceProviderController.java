package cn.gyx.springcloud.eureka.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceProviderController {

    @RequestMapping("/sysinfo")
    public String getSystemInfo(){
        return "123123";
    }
}
