package com.nineee.springboot.enity;

import org.springframework.stereotype.Component;

/**
 * @Author: ljj
 * @Date: 2019/7/1 11:10
 * @Desc
 */

@Component(value = "woman")
public class Womans {

    public void say(){
        System.out.println(">>>>>>>>>> woman is speaking");
    }

}
