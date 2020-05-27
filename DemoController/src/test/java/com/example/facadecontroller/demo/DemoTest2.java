package com.example.facadecontroller.demo;

import com.example.facadecontroller.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
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
public class DemoTest2 {

    @Test
    public void test() {
        List<User> list = new ArrayList<>();
        list.add(new User("小米","19"));
        list.add(new User("小名","26"));
        list.add(new User("小hua","16"));
        long count = list.stream().filter(user -> Integer.valueOf(user.getAge()) > 18).count();//年龄大于18 的个数
//        System.out.println(count);
        List<User> collect = list.stream().filter(user -> Integer.valueOf(user.getAge()) > 18).collect(Collectors.toList());
        collect.forEach(user -> System.out.println(user));//遍历user 的list集合
        List<String> collect1 = list.stream().filter(user -> Integer.valueOf(user.getAge()) > 18).map(user -> {
            return "50";
        }).collect(Collectors.toList()); //map 成一个新的list集合
        System.out.println(collect1);
        List<String> collect2 = list.stream().map(user -> user.getName()).collect(Collectors.toList());
        System.out.println(collect2);

        list.stream().filter(user -> Integer.valueOf(user.getAge()) > 18).forEach((p)-> System.err.println(p)); //过滤完之后进行遍历
        boolean b = list.stream().filter(user -> Integer.valueOf(user.getAge()) > 18).findFirst().isPresent();//过滤完之后进行遍历
        System.out.println(b);

        /**
         * 比较最大值和最小值  Optional
         */
        Optional<User> optional = list.stream().max((a, c) -> Integer.valueOf(a.getAge()) - Integer.valueOf(c.getAge()));
        if (optional.isPresent()) {
            System.out.println("最大值max="+optional.get().getAge());
            System.out.printf("Name: %s %s; Salary: ", optional.get().getAge(), optional.get().getName());
        }
        String name = list.stream().min((a, c) -> Integer.valueOf(a.getAge()) - Integer.valueOf(c.getAge())).get().getName();
        System.out.println("最小值的name="+name);
        int sum = list.stream().mapToInt((p) -> Integer.valueOf(p.getAge())).sum(); //将对象的斌两转为int类型
        System.out.println("三者求和"+sum);
    }

}
