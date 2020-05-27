package com.example.facadecontroller.demo;

import com.example.facadecontroller.demo.rabbitMq.RabbitMQProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @Test
    public void contextLoads() {
        long startTime = new Date().getTime();
//        String sender = rabbitMQProducer.sender();
        String cdlxsender = rabbitMQProducer.cdlxsender();
        long endTime = new Date().getTime();
//        System.out.println(sender);
        System.out.println(cdlxsender);
        System.out.println("消息发出耗时:{"+(endTime-startTime)+"}ms");
    }
    /**
     * 使用Jackson2JsonMessageConverter处理器，客户端发送JSON类型数据，但是没有指定消息的contentType类型，
     * 那么Jackson2JsonMessageConverter就会将消息转换成byte[]类型的消息进行消费。
     * 如果指定了contentType为application/json，那么消费端就会将消息转换成Map类型的消息进行消费。
     * 如果指定了contentType为application/json，并且生产端是List类型的JSON格式，那么消费端就会将消息转换成List类型的消息进行消费。
     */

}
