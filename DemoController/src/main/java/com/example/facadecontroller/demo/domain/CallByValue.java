package com.example.facadecontroller.demo.domain;

/**
 * @author Crh
 * @ProjectName DemoController
 * @Description: 按值调用
 * @date 2019/11/7 18:05
 */
public class CallByValue {

    private static int x=10;

    public static void updateValue(int value){
        value = 3 * value;
    }

    public static void main(String[] args) {
        System.out.println("调用前x="+x);
        updateValue(x);
        System.out.println("调用x="+x);
    }
}
