package com.zs.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Company
 * @Author Zs
 * @Date Create in 2019/9/9
 **/
@SpringBootApplication
@EnableDubbo
public class ApplicationRun8081 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun8081.class, args);
    }
}
