package com.example.facadecontroller.demo.exampleTest;

import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Crh
 * @ProjectName DemoController
 * @Description: 描述
 * @date 2019/9/26 10:27
 */
public class Demo1 {
    public static void main(String[] args) {
        List<BasicNameValuePair> list = new ArrayList();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("ki","ol");
        list.add(basicNameValuePair);
        list.add(new BasicNameValuePair("a","b"));
        for (BasicNameValuePair nameValuePair : list) {
            if ("k".equals(nameValuePair.getName())){
                break;
            }else {
                Scanner sc = new Scanner(System.in);
                System.out.println("请输入:");
                if (sc.hasNext()){
                    String tip = sc.next();
                    System.out.println("你输入的结果是"+tip);
                }
            }
        }
    }
}
