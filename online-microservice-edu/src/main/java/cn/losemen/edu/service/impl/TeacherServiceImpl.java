package cn.losemen.edu.service.impl;

import cn.losemen.edu.entity.Teacher;
import cn.losemen.edu.mapper.TeacherMapper;
import cn.losemen.edu.query.TeacherQuery;
import cn.losemen.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author HuangZhen
 * @since 2020-04-01
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public void pageQuery(Page<Teacher> pageParam, TeacherQuery teacherQuery) {
        //创建QueryWrapper对象
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        //设置根据字段sort升序
        queryWrapper.orderByAsc("sort");
        //没有传条件
        if(teacherQuery == null) {
            baseMapper.selectPage(pageParam,queryWrapper);
            return ;
        }
        //传递条件时，取出条件
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        if(!StringUtils.isEmpty(name)) {
            queryWrapper.like("name",name);
        }
        if(level != null) {
            queryWrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("gmt_creat",begin);
        }
        if(!StringUtils.isEmpty(end)) {
            queryWrapper.le("gmt_creat",end);
        }
        baseMapper.selectPage(pageParam,queryWrapper);

    }
}
