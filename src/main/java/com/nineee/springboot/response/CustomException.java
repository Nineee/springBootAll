package com.nineee.springboot.response;

/**
 * @Author: ljj
 * @Date: 2019/6/18 16:02
 * @Desc
 */
public class CustomException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public CustomException(String msg) {
        this.msg = msg;
    }

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public CustomException(String msg, int code) {
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
