package com.example.facadecontroller.demo.dao;

import com.example.facadecontroller.demo.domain.NewUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Crh
 * @ProjectName DemoController
 * @Description: 描述
 * @date 2019/11/1 14:24
 */
@Mapper
public interface UserMapper {

    public NewUser selectUserById(long id);

    public int insert(NewUser user);

    public List<NewUser> selectByColor(String color);

    int updateById(NewUser user);

    /**
     * 根据name模糊查询
     * @param name
     * @return
     */
    public List<NewUser> selectByName(String name);
}
