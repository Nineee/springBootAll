package com.nineee.springboot.response;

/**
 * @Author: ljj
 * @Date: 2019/6/18 16:02
 * @Desc
 */
public class CustomException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 1000;

    public CustomException(String msg) {
        this.msg = super.getMessage();
        this.msg = msg;
    }

    public CustomException(String msg, int code) {
        this.msg = super.getMessage();
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
