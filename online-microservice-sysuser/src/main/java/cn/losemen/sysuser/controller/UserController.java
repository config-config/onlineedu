package cn.losemen.sysuser.controller;

import cn.losemen.common.vo.R;
import cn.losemen.sysuser.entity.Sysuser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/2 - 22:01
 */
@Api(description="系统用户管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/admin/sysuser")
public class UserController {

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public R login(
            @ApiParam(name = "sysuser", value = "系统用户对象", required = true)
            @RequestBody Sysuser sysuser){
        System.out.println(1);

        return R.success().data("token", "admin");
    }

    @GetMapping("/info")
    @ApiOperation(value = "获取用户信息")
    public R info(
            @ApiParam(name = "token", value = "令牌", required = true)
            @RequestParam String token){
        return R.success()
                .data("roles", "admin")
                .data("name", "admin")
                .data("avatar", "https://online----edu.oss-cn-beijing.aliyuncs.com/avatar/avatar-boy.gif");
    }

    @PostMapping("/logout")
    @ApiOperation(value = "用户登出")
    public R logout(){
        return R.success();
    }
}
