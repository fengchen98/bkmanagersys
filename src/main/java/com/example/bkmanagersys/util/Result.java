package com.example.bkmanagersys.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 全局统一返回结果类
 *
 */
@Data
@ApiModel(value = "全局统一返回结果")
public class Result<T> {

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private T data;

    public Result(){}

    // 返回数据
    protected static <T> com.example.bkmanagersys.util.Result<T> build(T data) {
        com.example.bkmanagersys.util.Result<T> result = new com.example.bkmanagersys.util.Result<T>();
        if (data != null)
            result.setData(data);
        return result;
    }

    public static <T> com.example.bkmanagersys.util.Result<T> build(T body, com.example.bkmanagersys.util.ResultCodeEnum resultCodeEnum) {
        com.example.bkmanagersys.util.Result<T> result = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    public static<T> com.example.bkmanagersys.util.Result<T> ok(){
        return com.example.bkmanagersys.util.Result.ok(null);
    }

    /**
     * 操作成功
     * @param data
     * @param <T>
     * @return
     */
    public static<T> com.example.bkmanagersys.util.Result<T> ok(T data){
        com.example.bkmanagersys.util.Result<T> result = build(data);
        return build(data, com.example.bkmanagersys.util.ResultCodeEnum.SUCCESS);
    }

    public static<T> com.example.bkmanagersys.util.Result<T> fail(){
        return com.example.bkmanagersys.util.Result.fail(null);
    }

    /**
     * 操作失败
     * @param data
     * @param <T>
     * @return
     */
    public static<T> com.example.bkmanagersys.util.Result<T> fail(T data){
        com.example.bkmanagersys.util.Result<T> result = build(data);
        return build(data, com.example.bkmanagersys.util.ResultCodeEnum.FAIL);
    }

    public com.example.bkmanagersys.util.Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    public com.example.bkmanagersys.util.Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }


    public boolean isOk() {
        if(this.getCode().intValue() == com.example.bkmanagersys.util.ResultCodeEnum.SUCCESS.getCode().intValue()) {
            return true;
        }
        return false;
    }
}
