package cn.losemen.edu.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/5 - 11:14
 */
@ApiModel(value = "章节信息")
@Data
public class VideoVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private Boolean free;
    private String videoSourceId;
}
