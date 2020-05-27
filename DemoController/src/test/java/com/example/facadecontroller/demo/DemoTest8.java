package com.example.facadecontroller.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Crh
 * @ProjectName DemoController
 * @date 2019/10/14 11:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest8 {

    @Test
    public void test(){
        String type = "2";
        switch (type){
            case "2":
                System.out.println("111111");
                break;
                default:
                    System.out.println("走的default");
                    break;
        }
        System.out.println("2222");
    }

    /*
     * todo hashset的操作
     * 对于某些不定项操作可以利用哈希扩展
     */
    /*String userKey="user12";
		jedis.hset(userKey, "name", "jim");
		jedis.hset(userKey, "age", "12");
		jedis.hset(userKey, "phone", "12345678901");
    print(12,jedis.hget(userKey,"name"));
    print(13,jedis.hgetAll(userKey));
		jedis.hdel(userKey,"phone");//删除
    print(14,jedis.hgetAll(userKey));
    print(15,jedis.hkeys(userKey));//获取所有key
    print(16,jedis.hvals(userKey));//获取所有values
    print(17,jedis.hexists(userKey, "email"));//是否存在
    print(18,jedis.hexists(userKey, "age"));
		jedis.hsetnx(userKey, "school", "123");//不存在字段 添加，存在不改变
		jedis.hsetnx(userKey, "name", "Ben");
    print(19,jedis.hgetAll(userKey));*/

    //答案
//    12, jim
//13, {name=jim, phone=12345678901, age=12}
//14, {name=jim, age=12}
//15, [name, age]
//            16, [jim, 12]
//            17, false
//            18, true
//            19, {name=jim, school=123, age=12}



}
