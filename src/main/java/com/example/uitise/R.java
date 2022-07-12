package com.example.uitise;

import lombok.Data;

@Data
public class R {
    private boolean flage;
    private Object data;
    private String message;

    public R(){};

    public R(boolean flage){
        this.flage=flage;
    }

    public R(boolean flage,Object data){
        this.flage=flage;
        this.data=data;
    }

    public R(boolean flage,String message){
        this.flage=flage;
        this.message=message;
    }

    public R(String message){
        this.flage=false;
        this.message=message;
    }
}
