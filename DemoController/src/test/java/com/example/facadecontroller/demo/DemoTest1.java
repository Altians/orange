package com.example.facadecontroller.demo;

import com.example.facadecontroller.demo.domain.ResultTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Crh
 * @ProjectName DemoController
 * @Description: 描述FutureTask 的简单测试
 * @date 2019/10/14 11:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest1 {


    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Test
    public void test() throws ExecutionException, InterruptedException {
        ResultTest resultTest = new ResultTest();
        resultTest.setName("大厦");
        resultTest.setCode("000");
        FutureTask<ResultTest> futureTask = new FutureTask<ResultTest>(() -> {
            resultTest.setCode("123");
            return resultTest;
        });
        //提交任务
        taskExecutor.submit(futureTask);
        System.err.println(futureTask.get());
    }

}
