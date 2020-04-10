package cn.losemen.edu.service;

import cn.losemen.edu.entity.Chapter;
import cn.losemen.edu.vo.ChapterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author HuangZhen
 * @since 2020-04-01
 */
public interface ChapterService extends IService<Chapter> {
    void removeChapterById(String id);

    List<ChapterVo> nestedList(String courseId);
}
