package cn.losemen.edu.service;

import cn.losemen.edu.entity.Teacher;
import cn.losemen.edu.query.TeacherQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author HuangZhen
 * @since 2020-04-01
 */
public interface TeacherService extends IService<Teacher> {

    //带有条件的分页查询
    void pageQuery(Page<Teacher> teacherPage, TeacherQuery teacherQuery);
}
