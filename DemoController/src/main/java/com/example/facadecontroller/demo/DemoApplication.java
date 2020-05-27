package com.example.facadecontroller.demo;

import com.example.facadecontroller.demo.domain.NewUser;
import com.example.facadecontroller.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@EnableRabbit
@RestController
@SpringBootApplication
@EnableAspectJAutoProxy//切面开启
public class DemoApplication {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser/{id}")
        public String getUser(@PathVariable("id") long id) {
        NewUser newUser = userService.selectUser(id);
        System.out.println(newUser);
        return "SUCCESS";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
