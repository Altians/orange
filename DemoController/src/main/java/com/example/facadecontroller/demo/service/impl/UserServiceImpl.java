package com.example.facadecontroller.demo.service.impl;

import com.example.facadecontroller.demo.dao.UserMapper;
import com.example.facadecontroller.demo.domain.NewUser;
import com.example.facadecontroller.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Crh
 * @ProjectName DemoController
 * @Description: 描述
 * @date 2019/11/1 15:05
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public NewUser selectUser(long id) {

        return userMapper.selectUserById(id);
    }

    @Override
    public int insert(NewUser user) {
        int insert = userMapper.insert(user);//代码走到此处的时候可以正常插入数据
//        int i = 1/0;//走到此处的时候出现异常  by zero
        return insert;
    }
}
