package com.zwk.detection.entity;

public enum ResponseCode {
    UNKNOWN_ERROR(-1,"服务端未知错误"),
    SUCCESS(1,"成功"),
    DATA_IS_EMPTY(0,"未检测到物体"),
    ;
    private Integer code;
    private String msg;

    ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
