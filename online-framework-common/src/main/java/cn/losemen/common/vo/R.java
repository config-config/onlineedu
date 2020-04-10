package cn.losemen.common.vo;

import cn.losemen.common.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建结果类
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/1 - 18:05
 */
@Data
@ApiModel(value = "全局统一返回结果")
public class R {
    @ApiModelProperty(value = "返回状态码")
    private Integer code;
    @ApiModelProperty(value = "返回信息")
    private String message;
    @ApiModelProperty(value = "返回是否成功")
    private Boolean success;
    @ApiModelProperty(value = "返回数据")
    private Map<String,Object> data = new HashMap<String, Object>();
    //私有化构造方法
    private R() {

    }
    //提供静态的方法
    //返回成功
    public static R success() {
        R r = new R();
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        return r;
    }
        //返回失败
        public static R error() {
        R r = new R();
        r.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
        r.setMessage(ResultCodeEnum.UNKNOWN_REASON.getMessage());
        r.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
        return  r;
    }
    //处理特定的返回
    public static R setResult(ResultCodeEnum resultCodeEnum) {
        R r = new R();
        r.setSuccess(resultCodeEnum.getSuccess());
        r.setCode(resultCodeEnum.getCode());
        r.setMessage(resultCodeEnum.getMessage());
        return r;
    }
    public R data(Map<String,Object> map) {
        this.setData(map);
        return this;
    }
    public R data(String key,Object value) {
        this.data.put(key,value);
        return this;
    }
    //设置单个属性，链式调用
    public R message(String message) {
        this.setMessage(message);
        return this;
    }
    public R code(Integer code) {
        this.setCode(code);
        return this;
    }
    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

}
