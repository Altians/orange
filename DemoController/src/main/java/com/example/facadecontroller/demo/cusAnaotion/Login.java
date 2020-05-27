package com.example.facadecontroller.demo.cusAnaotion;

import java.lang.annotation.*;

import static org.springframework.web.bind.annotation.ValueConstants.DEFAULT_NONE;

/**
 * @author Crh
 * @ProjectName DemoController
 * @Description: 描述
 * @date 2019/12/3 9:44
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
   public String getMsg() default DEFAULT_NONE ;//不能直接使用null值，所以用16位unicode代替
}
