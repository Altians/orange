package com.example.facadecontroller.demo.exampleTest;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.example.facadecontroller.demo.domain.NewUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Crh
 * @ProjectName DemoController
 * @Description: 描述
 * @date 2019/9/26 10:27
 */
public class Demo2 {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Demo2.class);
        JSONObject data = new JSONObject();
        NewUser newUser = new NewUser(10L,"bad","123","小米",null,null,null);
        data.put("newUser",newUser);
        System.out.println(data);
    }
}
