package com.moore.web;

import com.moore.constant.enums.ResponseCode;
import com.moore.model.vo.MenuVO;
import com.moore.service.MenuService;
import com.moore.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    @ApiOperation("获取菜单")
    public Result menu() {
        List<MenuVO> menu = menuService.menu();
        return Result.success(ResponseCode.SUCCESS, menu);
    }
}
