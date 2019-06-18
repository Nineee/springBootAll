package com.nineee.springboot.web;

import com.nineee.springboot.response.CustomException;
import com.nineee.springboot.response.Result;
import com.nineee.springboot.response.UnionExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ljj
 * @Date: 2019/6/18 14:45
 * @Desc
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(UnionExceptionHandler.class);

    @GetMapping("/one")
    public Result testone(@RequestParam("name") String name){
        if(!name.equals("Nineee")){
            throw new CustomException("name不正确");
        }
        return Result.success();
    }
}
