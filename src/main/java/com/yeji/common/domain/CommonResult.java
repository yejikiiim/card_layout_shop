package com.yeji.common.domain;


import com.yeji.common.constant.ResCode;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CommonResult<T> {

    private int code;
    private String msg;
    private T result;
    
    public CommonResult(ResCode code, String msg, T result) {
        this.code = code.getCode();
        this.msg = msg;
        this.result = result;
    }
}
