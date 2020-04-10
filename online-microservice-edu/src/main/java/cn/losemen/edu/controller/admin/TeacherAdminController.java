package cn.losemen.edu.controller.admin;

import cn.losemen.common.constants.ResultCodeEnum;
import cn.losemen.common.exception.OnlineException;
import cn.losemen.common.vo.R;
import cn.losemen.edu.entity.Teacher;
import cn.losemen.edu.query.TeacherQuery;
import cn.losemen.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/1 - 17:15
 */
@CrossOrigin
@RestController
@RequestMapping("/admin/edu/teacher")
public class TeacherAdminController {
    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "查询全部讲师")
    @GetMapping
    public R getAllList() {
        List<Teacher> list = teacherService.list(null);
        return R.success().data("items", list);
    }
    @ApiOperation(value = "根据id删除讲师")
    @DeleteMapping("{id}")
    public R removeT(
            @ApiParam(name = "id",value = "讲师id",required = true)
            @PathVariable("id")String id) {
        teacherService.removeById(id);
        return R.success();
    }

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable("page") Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable("limit") Long limit,

            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
                    TeacherQuery teacherQuery){

        //当传递的参数错误时，抛出异常
        if(page <= 0 || limit <= 0) {
            throw new OnlineException(ResultCodeEnum.PARAM_ERROR);
        }
        Page<Teacher> pageParam = new Page<>(page, limit);

        teacherService.pageQuery(pageParam, teacherQuery);
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.success().data("total", total).data("rows", records);
    }
    @ApiOperation(value = "新增讲师")
    @PostMapping
    public R save(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher){

        teacherService.save(teacher);
        return R.success();
    }

    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id){

        Teacher teacher = teacherService.getById(id);
        return R.success().data("item", teacher);
    }
    @ApiOperation(value = "根据ID修改讲师")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id,
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher){

        teacher.setId(id);
        teacherService.updateById(teacher);
        return R.success();
    }
}
