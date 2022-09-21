package cn.gyx.springcloud.eureka.provider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class ServiceProviderController {

    @HystrixCommand(fallbackMethod = "TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })

    @RequestMapping("/sysinfo")
    public String getSystemInfo(){

        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "123123";
    }

    public String TimeoutHandler() {
        return "访问请求失败了，服务不可用";
    }

}
