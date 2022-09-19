package cn.gyx.springcloud.eureka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/sysinfo")
    public String getSystemInfo(){

        String url = "http://eureka-provider/sysinfo";

        return restTemplate.getForObject(url, String.class);
    }
}
