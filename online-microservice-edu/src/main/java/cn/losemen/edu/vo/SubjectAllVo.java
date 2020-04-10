package cn.losemen.edu.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/4 - 11:16
 */
@Data
public class SubjectAllVo {
    private String id;
    private String title;
    private List<SubjectAllVo> children = new ArrayList<>();
}
