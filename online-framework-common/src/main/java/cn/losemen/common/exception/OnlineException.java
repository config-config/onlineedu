package cn.losemen.common.exception;

import cn.losemen.common.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 自定义异常
 * RuntimeException 对代码没有侵入性
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/2 - 10:21
 */
@Data
@ApiModel(value = "自定义全局异常")
public class OnlineException extends RuntimeException {
    @ApiModelProperty(value = "状态码")
    private Integer code;
    /*
    接受状态码和错误消息
     */
    public OnlineException(Integer code,String message) {
        super(message);
        this.code = code;
    }
    public OnlineException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    //打印异常信息
    @Override
    public String toString() {
        return "OnlineException{" +
                "code=" + code +
                "-----message" + this.getMessage() +
                '}';
    }
}
