package cn.losemen.edu.service;

import cn.losemen.edu.entity.CourseDescription;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程简介 服务类
 * </p>
 *
 * @author HuangZhen
 * @since 2020-04-01
 */
public interface CourseDescriptionService extends IService<CourseDescription> {
    void insert(CourseDescription courseDescription);
    CourseDescription selectById(String id);
    boolean updateById(CourseDescription courseDescription);
}
