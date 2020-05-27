package com.example.facadecontroller.demo.controller;

import com.example.facadecontroller.demo.domain.NewUser;
import com.example.facadecontroller.demo.domain.ResultTest;
import com.example.facadecontroller.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/tom",method = {RequestMethod.GET,RequestMethod.POST})
    public ResultTest query(HttpServletRequest request) {
        ResultTest resultTest = new ResultTest();
        Random rd = new Random();
        int i = rd.nextInt(100);
        if (i % 2 == 0)
            resultTest.setUniteLoginStatus("3");
        else
            resultTest.setUniteLoginStatus("4");
        resultTest.setCode("000");
        resultTest.setName("安道尔");
        return resultTest;
    }

    /**
     * postMan 调用
     * CommonsMultipartFile实现了MultipartFile接口
     * MultipartFile 多部件文件上传
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/fileUpload")
    public String  fileUpload2(@RequestParam("file") MultipartFile file) throws IOException {
        long  startTime=System.currentTimeMillis();
        System.out.println("文件名称fileName："+file.getOriginalFilename()); //上传的文件名
        String path="E:/"+new Date().getTime()+file.getOriginalFilename();//上传的文件路径

        File newFile=new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        long endTime=System.currentTimeMillis();
        System.out.println("采用file.Transto的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "SUCCESS";
    }

    @RequestMapping("/insert")
    public int insert(){
        NewUser user = new NewUser(18L,"lop","1234","kitty","白色",null,"00:23:56");
        int insert = userService.insert(user);
//        int i = 1/0;
        if (insert > 0){
            return insert;
        }
        return 0;
    }

}
