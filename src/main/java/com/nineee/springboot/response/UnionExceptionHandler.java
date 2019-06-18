package com.nineee.springboot.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: ljj
 * @Date: 2019/6/18 14:48
 * @Desc
 */
@RestControllerAdvice
public class UnionExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(UnionExceptionHandler.class);

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        log.info("binder.getFieldDefaultPrefix {}",binder.getFieldDefaultPrefix());
        log.info("binder.getFieldMarkerPrefix {}",binder.getFieldMarkerPrefix());
    }
    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "harry");
    }
    /**
     * Description : 全局异常捕捉处理
     * Group :
     *
     * @author ljj
     * @date  2019/4/1 0001 10:34
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result apiExceptionHandler(CustomException e) {
        log.error(">>>>> 异常抛出：{}", e.getMsg());
        return new Result(e.getMsg());
    }

}

