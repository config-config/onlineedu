package cn.losemen.edu.service;

import cn.losemen.edu.entity.Course;
import cn.losemen.edu.form.CourseInfoForm;
import cn.losemen.edu.query.CourseQuery;
import cn.losemen.edu.vo.CoursePublishVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author HuangZhen
 * @since 2020-04-01
 */
public interface CourseService extends IService<Course> {

    /**
     * 保存课程和课程详情信息
     * @param courseInfoForm
     * @return 新生成的课程id
     */
    String saveCourseInfo(CourseInfoForm courseInfoForm);

    CourseInfoForm getCourseInfoFormById(String id);

    void updateCourseInfoById(CourseInfoForm courseInfoForm);

    void pageQuery(Page<Course> pageParam, CourseQuery courseQuery);

    boolean removeCourseById(String id);

    CoursePublishVo getCoursePublishVoById(String id);
    void publishCourseById(String id);
}
