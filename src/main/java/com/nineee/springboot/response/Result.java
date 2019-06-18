package com.nineee.springboot.response;

/**
 * @Author: ljj
 * @Date: 2019/6/18 14:48
 * @Desc
 */
public class Result<T>{
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;
    /** 具体的内容. */
    private T data;

    public static Result success(Object o){
        return new Result(ResultEnum.SUCCESS.getMsg(),ResultEnum.SUCCESS.getCode(),o);
    }

    public static Result success(){
        return new Result(ResultEnum.SUCCESS.getMsg(),ResultEnum.SUCCESS.getCode());
    }

    public Result(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public Result(String msg, int code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result(String msg) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

