package cn.losemen.oss.controller;

import cn.losemen.common.vo.R;
import cn.losemen.oss.service.FileService;
import cn.losemen.oss.util.ConstantProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/3 - 14:52
 */
@CrossOrigin
@RestController
@Api(description = "阿里云文件管理")
@RequestMapping("/admin/oss/file")
public class FileController {
    @Autowired
    private FileService fileService;


    /**
     * 文件上传
     *
     * @param file
     */
    @ApiOperation(value = "文件上传")
    @PostMapping("upload")
    public R upload(
            @ApiParam(name = "file", value = "文件", required = true)
            @RequestParam("file") MultipartFile file,

            @ApiParam(name = "host", value = "文件上传路径", required = false)
            @RequestParam(value = "host", required = false) String host) {

        if(!StringUtils.isEmpty(host)){
            ConstantProperties.FILE_HOST = host;
        }
        String uploadUrl = fileService.uploadFile(file);
        //返回r对象
        return R.success().message("文件上传成功").data("url", uploadUrl);

    }
}
