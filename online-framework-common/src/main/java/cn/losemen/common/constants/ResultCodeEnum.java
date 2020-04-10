package cn.losemen.common.constants;

import lombok.Getter;

/**
 * 创建返回码生成枚举类
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/1 - 18:03
 */
@Getter  //生成get方法
public enum ResultCodeEnum {
    //调用枚举构造函数，创建对象
    SUCCESS(true, 20000,"成功"),
    UNKNOWN_REASON(false, 20001, "未知错误"),
    BAD_SQL_GRAMMAR(false, 21001, "sql语法错误"),
    JSON_PARSE_ERROR(false, 21002, "json解析异常"),
    PARAM_ERROR(false, 21003, "参数不正确"),
    FILE_UPLOAD_ERROR(false, 21004, "文件上传错误"),
    EXCEL_DATA_IMPORT_ERROR(false, 21005, "Excel数据导入错误"),
    VIDEO_UPLOAD_TOMCAT_ERROR(false,21006,"视频上传失败"),
    VIDEO_UPLOAD_ALIYUN_ERROR(false,21007,"视频上传失败"),
    VIDEO_DELETE_ALIYUN_ERROR(false,21008 ,"视频删除失败" ),
    FETCH_PLAYAUTH_ERROR(false, 21009,"视频播放失败" );

    private Boolean success;

    private Integer code;

    private String message;

    private ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
