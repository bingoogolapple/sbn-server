package cn.bingoogolapple.sbn.controller;

import cn.bingoogolapple.sbn.dto.ResultDto;
import cn.bingoogolapple.sbn.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "User", description = "用户管理")
@RequestMapping("api/user")
@RestController
public class UserController {

    @ApiOperation(notes = "添加用户", value = "添加用户")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, paramType = "body", dataType = "User")
    @PostMapping
    public ResultDto create(@RequestBody User user) {
        return ResultDto.data("添加用户成功");
    }
}