package com.example.facadecontroller.demo;

import com.example.facadecontroller.demo.utils.BaseHolder;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Crh
 * @ProjectName DemoController
 * @date 2019/10/14 11:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest6 {

    @Autowired
   private BaseHolder baseHolder;

    @Test
    public void test(){
        /**
         * 获取上下文对象context
         */
        ApplicationContext context = baseHolder.getContext();
        System.out.println(context.getId());
        Object userServiceImpl = context.getBean("userServiceImpl");
        System.out.println(userServiceImpl);
        String s = "111";
        String concat = s.concat("23");//拼接字符串

        Random random = new Random();
        int anInt = random.nextInt(999);
        System.out.println(anInt);
        String format = String.format("%03d",anInt);//3代表规定数字的总位数  d代表是整型 少于3位前面补0
        System.out.println(format);
    }



}
