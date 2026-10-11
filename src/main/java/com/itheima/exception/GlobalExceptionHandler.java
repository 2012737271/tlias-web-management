package com.itheima.exception;

import com.itheima.pojo.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result handleHttpMessageNotReadable(HttpMessageNotReadableException e) {
        e.printStackTrace();
        return Result.error("请求体格式错误，请确保发送的是JSON格式数据，且Content-Type为application/json");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException e) {
        e.printStackTrace();
        return Result.error("请求参数类型不匹配: " + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.error("服务器内部错误: " + e.getMessage());
    }
}