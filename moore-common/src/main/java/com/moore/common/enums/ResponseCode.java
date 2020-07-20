package com.moore.common.enums;

public enum ResponseCode {
    SUCCESS(200, "成功"),
    /* 失败状态码 */
    FAILURE(0, "失败"),
    ;
    private Integer code;

    private String message;

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessage(String name) {
        for (ResponseCode item : ResponseCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResponseCode item : ResponseCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
