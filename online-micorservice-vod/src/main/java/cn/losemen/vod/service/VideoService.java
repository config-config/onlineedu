package cn.losemen.vod.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/6 - 15:10
 */
public interface VideoService {
    String uploadVideo(MultipartFile file);

    void removeVideo(String videoId);

    String getVideoPlayAuth(String videoId);
}
