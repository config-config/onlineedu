package cn.losemen.vod.service.impl;

import cn.losemen.common.constants.ResultCodeEnum;
import cn.losemen.common.exception.OnlineException;
import cn.losemen.vod.service.VideoService;
import cn.losemen.vod.util.AliyunVODSDKUtils;
import cn.losemen.vod.util.ConstantPropertiesUtil;
import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/6 - 15:10
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Override
    public String uploadVideo(MultipartFile file) {

        String fileName = file.getOriginalFilename();
        String title = fileName.substring(0, fileName.lastIndexOf("."));
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            //e.printStackTrace();
            throw new OnlineException(ResultCodeEnum.VIDEO_UPLOAD_TOMCAT_ERROR);
        }
        UploadStreamRequest request = new UploadStreamRequest(
                ConstantPropertiesUtil.ACCESS_KEY_ID,
                ConstantPropertiesUtil.ACCESS_KEY_SECRET,
                title,
                fileName,
                inputStream);

        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadStreamResponse response = uploader.uploadStream(request);

        String videoId = response.getVideoId();

        if (!response.isSuccess()) {
            //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。
            // 其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
            if(StringUtils.isEmpty(videoId)){
                throw new OnlineException(ResultCodeEnum.VIDEO_UPLOAD_ALIYUN_ERROR);
            }
        }
        return videoId;
    }

    @Override
    public void removeVideo(String videoId) {

        DefaultAcsClient client = null;
        try {
            client = AliyunVODSDKUtils.initVodClient(
                    ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET);

            DeleteVideoRequest request = new DeleteVideoRequest();
            request.setVideoIds(videoId);

            DeleteVideoResponse response = client.getAcsResponse(request);

        } catch (ClientException e) {
            throw new OnlineException(ResultCodeEnum.VIDEO_DELETE_ALIYUN_ERROR);
        }

    }
    @Override
    public String getVideoPlayAuth(String videoId) {
        DefaultAcsClient client = null;
        try {
            client = AliyunVODSDKUtils.initVodClient(
                    ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET);

            //请求
            GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
            request.setVideoId(videoId);

            //响应
            GetVideoPlayAuthResponse response = client.getAcsResponse(request);

            //得到播放凭证
            String playAuth = response.getPlayAuth();
            System.out.println(playAuth);
            return playAuth;
        } catch (ClientException e) {
            throw new OnlineException(ResultCodeEnum.FETCH_PLAYAUTH_ERROR);
        }
    }
}