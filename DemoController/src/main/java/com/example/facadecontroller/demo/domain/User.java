package com.example.facadecontroller.demo.domain;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * @author Crh
 * @ProjectName DemoController
 * @Description: 描述
 * @date 2019/10/14 15:11
 */
public class User implements Serializable {
    @ColumnTransformer
    @Length(min = 3,max = 6)
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public User() {
    }

}
