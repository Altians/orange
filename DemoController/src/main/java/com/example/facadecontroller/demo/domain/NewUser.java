package com.example.facadecontroller.demo.domain;

import java.io.Serializable;
import java.sql.Date;
import java.time.DateTimeException;

/**
 * @author Crh
 * @ProjectName DemoController
 * @Description: 描述
 * @date 2019/11/1 18:17
 */
public class NewUser implements Serializable {

    private long id;
    private String user_name;
    private String password;
    private String name;
    private String color;
    private Date work_add_time;
    private String work_add_end_time;

    public NewUser(long id, String user_name, String password, String name, String color, Date work_add_time, String work_add_end_time) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.name = name;
        this.color = color;
        this.work_add_time = work_add_time;
        this.work_add_end_time = work_add_end_time;
    }

    public Date getWork_add_time() {
        return work_add_time;
    }

    public void setWork_add_time(Date work_add_time) {
        this.work_add_time = work_add_time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWork_add_end_time() {
        return work_add_end_time;
    }

    public void setWork_add_end_time(String work_add_end_time) {
        this.work_add_end_time = work_add_end_time;
    }
}
