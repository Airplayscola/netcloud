package com.lanou.utils;

/**
 * Created by dllo on 17/10/11.
 */
public class AjaxResult {

    private String message;
    private Integer errorcode;
    private Object data;

    public AjaxResult() {
    }

    public AjaxResult(Object data) {
        this.errorcode=0;
        this.message="成功";
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(Integer errorcode) {
        this.errorcode = errorcode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "message='" + message + '\'' +
                ", errorcode=" + errorcode +
                ", data=" + data +
                '}';
    }
}
