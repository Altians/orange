package com.example.facadecontroller.demo;

import com.example.facadecontroller.demo.domain.User;
import com.rabbitmq.client.BlockedCallback;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Crh
 * @ProjectName DemoController
 * @Description: 描述lamuda的属性的一些用法
 * @date 2019/10/14 11:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest3 {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        //distinct 去重
        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
//        System.out.println(collect);
        System.out.println(list.lastIndexOf(3));
       /* for (int i = 0; i < list.size(); i++)
            if (list!= null)
                System.out.println(1);*/
        /**
         * Integer::parseInt //静态方法引用
         * System.out::print //实例方法引用
         * Person::new       //构造器引用
         */
    }

}
