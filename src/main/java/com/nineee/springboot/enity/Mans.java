package com.nineee.springboot.enity;

import groovy.transform.ToString;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: ljj
 * @Date: 2019/6/26 15:02
 * @Desc
 */
@Data
@Component(value = "man")
public class Mans {
    //姓名
    private String name;

    public void say(){
        System.out.println(">>>>>>>>>> man is speaking");
    }

}
