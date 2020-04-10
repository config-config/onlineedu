package cn.losemen.common.handler;

import cn.losemen.common.constants.ResultCodeEnum;
import cn.losemen.common.exception.OnlineException;
import cn.losemen.common.util.ExceptionUtil;
import cn.losemen.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/2 - 10:07
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /*
    统一异常处理方法
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public R errors(Exception e) {
        //输出异常信息
        log.error(ExceptionUtil.getMessage(e));
        return R.error();
    }
    /*
    处理sql语法异常
     */
    @ResponseBody
    @ExceptionHandler(BadSqlGrammarException.class)
    public R errors(BadSqlGrammarException e) {
        //输出异常信息
        log.error(ExceptionUtil.getMessage(e));
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }
    /*
    json解析异常
     */
    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R errors(HttpMessageNotReadableException e) {
        //输出异常信息
        log.error(ExceptionUtil.getMessage(e));
        return R.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }

    /*
    自定义异常
     */
    @ResponseBody
    @ExceptionHandler(OnlineException.class)
    public R errors(OnlineException e) {
        //输出异常信息
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message(e.getMessage()).code(e.getCode());
    }
}
