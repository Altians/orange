package com.example.facadecontroller.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Crh
 * @ProjectName DemoController
 * @date 2019/10/14 11:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest7 {

    @Test
    public void test(){
        /**
         * 获取系统的属性
         */
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("os.version"));//操作系统版本
        System.out.println(System.getProperty("java.home"));//jvm的路径
        System.out.println(System.getProperty("user.dir"));//

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");//获取当前小时
        String format = simpleDateFormat.format(new Date());
        Integer value = Integer.valueOf(format);
        if (0 <= value && value <= 6){
            System.out.println("凌晨");
        }else {
            System.out.println(value);
        }
        String s1 = "str";
        String s2 = "ing";
        String s3 = "str"+"ing"; //常量池中的对象
        String s4 = s1+s2; //拼接 将会通过stringBuilder的append方法拼接 然后 tostring方法，最终返回的是一个“重新创建”的String对象
        String s5 = "string";//在常量池中
        System.out.println(s3==s4);//false
        System.out.println(s3==s5);//true
        System.out.println(s3.equals(s5));//true  同一个引用
        System.out.println(s4==s5);//false

    }



}
