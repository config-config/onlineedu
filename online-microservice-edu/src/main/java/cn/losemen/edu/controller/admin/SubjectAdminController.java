package cn.losemen.edu.controller.admin;

import cn.losemen.common.constants.ResultCodeEnum;
import cn.losemen.common.exception.OnlineException;
import cn.losemen.common.vo.R;
import cn.losemen.edu.service.SubjectService;
import cn.losemen.edu.vo.SubjectAllVo;
import cn.losemen.edu.vo.SubjectNestedVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 添加一级分类和二级分类
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/4 - 9:31
 */
@RestController
@CrossOrigin
@Api(description = "课程分类管理")
@RequestMapping("/admin/edu/subject")
public class SubjectAdminController {
    @Autowired
    private SubjectService subjectService;

    @ApiOperation(value = "Excel批量导入")
    @PostMapping("/import")
    public R batchImport(
            @ApiParam(value = "Excel文件",name = "file",required = true)
            @RequestParam("file")MultipartFile file) {
        try {
            List<String> errors = subjectService.batchImport(file);
            System.out.println(errors);
            if(errors.size() == 0) {
                return R.success().message("批量导入成功");
            } else {
                return R.error().message("部分数据导入失败").data("errorsList",errors);
            }
        }catch(Exception e) {
            throw new OnlineException(ResultCodeEnum.EXCEL_DATA_IMPORT_ERROR);
        }

    }
    @ApiOperation(value = "嵌套数据列表")
    @GetMapping
    public R nestedList(){

        List<SubjectNestedVo> subjectNestedVoList = subjectService.nestedList();
        return R.success().data("items", subjectNestedVoList);
    }

    @ApiOperation(value = "嵌套数据列表优化")
    @GetMapping("/list")
    public R allList(){
        List<SubjectAllVo> subjectAllVos = subjectService.allList();
        return R.success().data("items", subjectAllVos);
    }


}
