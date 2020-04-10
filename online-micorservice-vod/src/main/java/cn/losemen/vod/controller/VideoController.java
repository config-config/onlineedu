package cn.losemen.vod.controller;

import cn.losemen.common.vo.R;
import cn.losemen.vod.service.VideoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/7 - 10:37
 */
@Api(description="阿里云视频点播微服务")
@CrossOrigin //跨域
@RestController
@RequestMapping("/vod/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("get-play-auth/{videoId}")
    public R getVideoPlayAuth(@PathVariable("videoId") String videoId) {

        ///得到播放凭证
        String playAuth = videoService.getVideoPlayAuth(videoId);

        //返回结果
        return R.success().message("获取凭证成功").data("playAuth", playAuth);
    }
}