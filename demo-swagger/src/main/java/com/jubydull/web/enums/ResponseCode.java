package com.jubydull.web.enums;


public enum ResponseCode {
    OPERATION_SUCCESSFUL(100),
    RECORD_NOT_FOUND(101),
    AUTHENTICATION_FAILED(104),
    INVALID_ARGUMENT(103),
    DATABASE_ERROR(110),
    RUNTIME_ERROR(500),
    REMOTE_ERROR(502),
    INTERNAL_CONNECTION_ERROR(503);

    private int code;

    private ResponseCode(int code){
        this.code=code;
    }

    public int getCode() {
        return code;
    }
}
