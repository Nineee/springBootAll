package com.nineee.springboot.web;

import com.nineee.springboot.response.CustomException;
import com.nineee.springboot.response.DynamicSubject;
import com.nineee.springboot.response.Result;
import com.nineee.springboot.service.TestService;
import com.nineee.springboot.service.impl.TestServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;

/**
 * @Author: ljj
 * @Date: 2019/6/18 14:45
 * @Desc
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/one")
    public Result testone(@RequestParam("name") String name){
        if(name.equals("Ninee")){
            throw new NullPointerException();
        }
        if("-1".equals(name)){
            return Result.success(1/0);
        }
        if(name.equals("Nine")){
            throw new CustomException("name不正确");
        }

        return Result.success();
    }
}
