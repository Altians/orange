package com.example.facadecontroller.demo.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Crh
 * @ProjectName DemoController
 * @Description: 描述
 * @date 2019/10/24 13:46
 */
@RestController
public class CookieController {

    public String setCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("username", "jack");
        cookie.setMaxAge(60 * 60 * 24* 7); //过期时间
        response.addCookie(cookie);
        return "username is changed";
    }
    @RequestMapping("facade/test")
    public void route(HttpServletRequest request,HttpServletResponse response) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        response.setContentType("application/json");
        String requestURI = request.getRequestURI();  //    /facade/test
        System.out.println(requestURI);
        try {
            Map<String,Object> map = new HashMap<>();
            map.put("hexue","赵文卓");
            map.put("andriod","安靖");
            outputStream.write(JSON.toJSONBytes(map));
            outputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            outputStream.close();
        }
    }

}
