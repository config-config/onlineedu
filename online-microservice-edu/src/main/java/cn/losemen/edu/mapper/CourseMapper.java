package cn.losemen.edu.mapper;

import cn.losemen.edu.entity.Course;
import cn.losemen.edu.vo.CoursePublishVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author HuangZhen
 * @since 2020-04-01
 */
public interface CourseMapper extends BaseMapper<Course> {
    CoursePublishVo selectCoursePublishVoById(String id);
}
