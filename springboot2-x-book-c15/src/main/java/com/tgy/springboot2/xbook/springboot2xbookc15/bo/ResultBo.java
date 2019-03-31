package com.tgy.springboot2.xbook.springboot2xbookc15.bo;

import java.io.Serializable;

/**
 * @ClassName ResultBo
 */
public class ResultBo implements Serializable {

    private static final long serialVersionUID = 6162893526045032418L;


    private boolean success = false;
    private String message = null;

    public ResultBo() {
    }

    public ResultBo(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultBo{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
