package cn.losemen.vod.controller;

import cn.losemen.common.vo.R;
import cn.losemen.vod.service.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/6 - 15:23
 */
@Api(description="阿里云视频点播微服务")
@CrossOrigin //跨域
@RestController
@RequestMapping("/admin/vod/video")
public class VideoAdminController {

    @Autowired
    private VideoService videoService;

    @PostMapping("/upload")
    public R uploadVideo(
            @ApiParam(name = "file", value = "文件", required = true)
            @RequestParam("file") MultipartFile file) throws Exception {

        String videoId = videoService.uploadVideo(file);
        return R.success().message("视频上传成功").data("videoId", videoId);
    }
    @DeleteMapping("{videoId}")
    public R removeVideo(
            @ApiParam(name="videoId", value="阿里云视频id", required = true)
            @PathVariable String videoId){
        videoService.removeVideo(videoId);
        return R.success().message("视频删除成功");
    }
}