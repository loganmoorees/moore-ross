package com.moore.web;

import com.moore.constant.enums.ResponseCode;
import com.moore.model.entity.UserEntity;
import com.moore.service.UserService;
import com.moore.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("用户模块")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation("用户注册")
    public String register(@RequestBody UserEntity userEntity) {
        return userService.register(userEntity);
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result login(@RequestBody UserEntity userEntity) {
        String token = userService.login(userEntity);
        if (!token.equals("false"))
            return Result.success(ResponseCode.SUCCESS, token);
        else
            return Result.failed(ResponseCode.FAILURE, token);
    }
}
