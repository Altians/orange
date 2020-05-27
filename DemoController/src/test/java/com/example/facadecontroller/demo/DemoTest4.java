package com.example.facadecontroller.demo;

import com.example.facadecontroller.demo.dao.UserMapper;
import com.example.facadecontroller.demo.domain.NewUser;
import com.example.facadecontroller.demo.service.UserService;
import org.apache.ibatis.io.Resources;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Crh
 * @ProjectName DemoController
 * @date 2019/10/14 11:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest4 {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        System.err.println(userService.selectUser(2));
    }

    @Test
    public void test1() {
        List<NewUser> list = userMapper.selectByColor("绿色");
        NewUser user = list.get(list.size()-1);
        user.setColor("黑色");
        int i = userMapper.updateById(user);
        System.err.println(i);
        System.err.println(user.getId());
    }
}
