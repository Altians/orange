package com.example.facadecontroller.demo.service;

import com.example.facadecontroller.demo.domain.NewUser;

/**
 * @author Crh
 * @ProjectName DemoController
 * @Description: 描述
 * @date 2019/11/1 15:04
 */
public interface UserService {

    public NewUser selectUser(long id);

    public int insert(NewUser user);
}
