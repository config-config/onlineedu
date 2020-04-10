package cn.losemen.edu.mapper;

import cn.losemen.edu.entity.Subject;
import cn.losemen.edu.vo.SubjectAllVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author HuangZhen
 * @since 2020-04-01
 */
public interface SubjectMapper extends BaseMapper<Subject> {

    List<SubjectAllVo> selectSubjectList(String parenrId);

}
