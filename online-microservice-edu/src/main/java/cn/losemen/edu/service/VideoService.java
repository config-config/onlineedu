package cn.losemen.edu.service;

import cn.losemen.edu.entity.Video;
import cn.losemen.edu.form.VideoInfoForm;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author HuangZhen
 * @since 2020-04-01
 */
public interface VideoService extends IService<Video> {
    void saveVideoInfo(VideoInfoForm videoInfoForm);
    VideoInfoForm getVideoInfoFormById(String id);

    void updateVideoInfoById(VideoInfoForm videoInfoForm);
    void removeVideoById(String id);
}
