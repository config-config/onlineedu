package cn.losemen.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/3 - 14:31
 */
public interface FileService {
    String uploadFile(MultipartFile file);
}
