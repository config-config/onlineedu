package cn.losemen.edu.service;

import cn.losemen.edu.entity.Subject;
import cn.losemen.edu.vo.SubjectAllVo;
import cn.losemen.edu.vo.SubjectNestedVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author HuangZhen
 * @since 2020-04-01
 */
public interface SubjectService extends IService<Subject> {
    //上传excel读取文件中的内容
    List<String> batchImport(MultipartFile file) throws Exception;

    List<SubjectNestedVo> nestedList();

    List<SubjectAllVo> allList();
}
