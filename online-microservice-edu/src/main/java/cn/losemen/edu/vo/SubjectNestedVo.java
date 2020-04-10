package cn.losemen.edu.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 一级分类
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/4 - 10:59
 */
@Data
public class SubjectNestedVo {

    private String id;
    private String title;
    private List<SubjectVo> children = new ArrayList<>();
}
