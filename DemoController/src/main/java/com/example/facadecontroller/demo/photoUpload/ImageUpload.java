package com.example.facadecontroller.demo.photoUpload;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.nio.charset.Charset;

/**
 * @author Crh
 * @ProjectName DemoController
 * @Description: MultipartEntityBuilder 图片上传
 * @date 2019/9/17 15:29
 */
public class ImageUpload {
    public static void main(String[] args) {
        CloseableHttpClient build = HttpClientBuilder.create().build();


        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        multipartEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        multipartEntityBuilder.setCharset(Charset.forName("utf-8"));

    }
}
