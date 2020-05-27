package com.example.facadecontroller.demo.domain;

import java.io.Serializable;


public class ResultTest implements Serializable {
    private String code;
    private String uniteLoginStatus;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUniteLoginStatus() {
        return uniteLoginStatus;
    }

    public void setUniteLoginStatus(String uniteLoginStatus) {
        this.uniteLoginStatus = uniteLoginStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ResultTest{" +
                "code='" + code + '\'' +
                ", uniteLoginStatus='" + uniteLoginStatus + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
