package com.moore.product.web;

import com.moore.common.enums.ResponseCode;
import com.moore.common.utils.Result;
import com.moore.product.model.vo.SeriesVo;
import com.moore.product.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 货品分类
 *
 * @author Moore
 */
@RestController
@RequestMapping("product")
public class ProductTypeController {

    /**
     * 货品分类服务层
     */
    @Autowired
    ProductTypeService productTypeService;

    @GetMapping("type")
    public Result getProductTypeMenu() {
        List<SeriesVo> productTypeMenu = productTypeService.getProductTypeMenu();
        return Result.success(ResponseCode.SUCCESS, productTypeMenu);
    }
}