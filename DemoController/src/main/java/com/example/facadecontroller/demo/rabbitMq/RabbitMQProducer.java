package com.example.facadecontroller.demo.rabbitMq;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Crh
 * @ProjectName DemoController
 * @Description: 描述
 * @date 2019/9/19 21:47
 */
@Component
public class RabbitMQProducer {

    private static final String exchange = "TextChange";
    private static final String routingKey = "TextRouting";

    @Autowired
    private RabbitTemplate rabTemplate;

    /**
     * 发送消息--至ce11
     * @return
     */
    public String sender(){
        Map<String,Object> map = new HashMap<>();
        map.put("apple","苹果");
        map.put("huawei","华为");
        rabTemplate.convertAndSend("two_exchange","1234",JSON.toJSONString(map));
        return "SUCCESS";
    }

    @RabbitListener(queues = "ce11")
    public void listenerMessage(byte[] message){
        System.out.println("通过监听收到message:"+new String(message));
    }


    @RequestMapping("/dead")
    public void deadLetter() {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
//        声明消息处理器  这个对消息进行处理  可以设置一些参数   对消息进行一些定制化处理   我们这里  来设置消息的编码  以及消息的过期时间  因为在.net 以及其他版本过期时间不一致   这里的时间毫秒值 为字符串
        MessagePostProcessor messagePostProcessor = message -> {
            MessageProperties messageProperties = message.getMessageProperties();
//            设置编码
            messageProperties.setContentEncoding("utf-8");
//            设置过期时间10*1000毫秒
            messageProperties.setExpiration("10000");
            return message;
        };
//         向DL_QUEUE 发送消息  10*1000毫秒后过期 形成死信
        rabTemplate.convertAndSend("cdlx-hitLibrary-exchange", "hitLibrary-master", "adsfa", messagePostProcessor, correlationData);
    }

    public String cdlxsender(){
        Map<String,Object> map = new HashMap<>();
        map.put("apple","苹果xs");
        map.put("huawei","华为");
        rabTemplate.convertAndSend("cdlx-hitLibrary-exchange","hitLibrary-master",JSON.toJSONString(map));
        return "SUCCESS";
    }

    @RabbitListener(queues = "cdlx-hitLibrary-master")
    public void cdlxMessage(byte[] message){
        System.out.println("通过监听收到cdlxmessage:"+new String(message));
    }

}
