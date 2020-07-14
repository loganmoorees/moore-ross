package com.moore.utils;

import com.moore.constant.enums.ResponseCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Result implements Serializable {

    private Integer code;

    private String msg;

    private Object data;

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
