package com.example.facadecontroller.demo;

import com.example.facadecontroller.demo.dao.UserMapper;
import com.example.facadecontroller.demo.domain.NewUser;
import com.example.facadecontroller.demo.domain.enumExample.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Crh
 * @ProjectName DemoController
 * @date 2019/10/14 11:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest9 {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        List<NewUser> newUsers = userMapper.selectByName("小李");
//        System.out.println(newUsers);
        UserInfo[] values = UserInfo.values();
//        System.out.println(values);
//        System.out.println(UserInfo.eCode("name"));
        /**
         * 将double转换成String类型的，就可以转化正常了
         */
        double b = new BigDecimal("0.03").setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
        System.out.println(b);

    }


}

