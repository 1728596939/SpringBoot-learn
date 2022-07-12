package com.example.uitise;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(Exception.class)//用来设定拦截哪些异常
    public R doOtherException(Exception ex){

        //记录日志，
        //发消息给运维
        //发送给开发人员

        ex.printStackTrace();//在命令行打印异常信息在程序中出错的位置及原因。
        return new R("系统运行错误，请稍后再试");


    }




}
