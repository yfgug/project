package com.example.dormitory.common;

public class Result<T> {
    private int code;
    private String msg;
    private T data;

    // 构造函数
    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(200, "成功", data);
    }

    // 成功方法（两个参数）
    public static <T> Result<T> success(T data, String message) {
        return new Result<>(200, message, data);
    }

    // 成功方法（无数据）
    public static <T> Result<T> success(String message) {
        return new Result<>(200, message, null);
    }

    // 错误方法
    public static <T> Result<T> error(String message) {
        return new Result<>(500, message, null);
    }

    // 错误方法（带错误码）
    public static <T> Result<T> error(int code, String message) {
        return new Result<>(code, message, null);
    }

    // Getter 和 Setter
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
