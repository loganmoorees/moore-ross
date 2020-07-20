package com.moore.common.utils;

import com.moore.common.enums.ResponseCode;

import java.io.Serializable;

public class Result implements Serializable {

    private Integer code;

    private String msg;

    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result success(ResponseCode code, Object data) {
        Result result = new Result();
        result.setCode(code.code());
        result.setMsg(code.message());
        result.setData(data);
        return result;
    }

    public static Result failed(ResponseCode code, Object data) {
        Result result = new Result();
        result.setCode(code.code());
        result.setMsg(code.message());
        result.setData(data);
        return result;
    }
}
