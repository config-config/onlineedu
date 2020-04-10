package cn.losemen.edu.service.impl;

import cn.losemen.edu.entity.CourseDescription;
import cn.losemen.edu.mapper.CourseDescriptionMapper;
import cn.losemen.edu.service.CourseDescriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * <p>
 * 课程简介 服务实现类
 * </p>
 *
 * @author HuangZhen
 * @since 2020-04-01
 */
@Service
public class CourseDescriptionServiceImpl extends ServiceImpl<CourseDescriptionMapper, CourseDescription> implements CourseDescriptionService {

    @Override
    public void insert(CourseDescription courseDescription) {
        baseMapper.insert(courseDescription);

    }

    @Override
    public CourseDescription selectById(String id) {
        return baseMapper.selectById(id);
    }

}
