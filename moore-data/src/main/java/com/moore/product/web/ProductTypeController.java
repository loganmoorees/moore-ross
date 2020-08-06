package com.moore.product.web;

import com.moore.common.enums.ResponseCode;
import com.moore.common.utils.Result;
import com.moore.product.model.vo.SeriesTypeVo;
import com.moore.product.model.vo.SeriesVo;
import com.moore.product.model.vo.SubjectVo;
import com.moore.product.service.ProductTypeService;
import com.moore.product.service.SeriesTypeService;
import com.moore.product.service.SubjectService;
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
@RequestMapping("/product")
public class ProductTypeController {

    /**
     * 货品分类服务层
     */
    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    SeriesTypeService seriesTypeService;

    @Autowired
    SubjectService subjectService;

    /**
     * 物料类型导航栏
     *
     * @return
     */
    @GetMapping("/type")
    public Result getProductTypeMenu() {
        List<SeriesVo> productTypeMenu = productTypeService.getProductTypeMenu();
        return Result.success(ResponseCode.SUCCESS, productTypeMenu);
    }

    @GetMapping("/deadline")
    public Result getProductDeadline() {
        List<SeriesTypeVo> list = seriesTypeService.getProductDeadline();
        return Result.success(ResponseCode.SUCCESS, list);
    }

    @GetMapping("/storage")
    public Result putStorageType() {
        List<SubjectVo> list = subjectService.getPutStorageType();
        return Result.success(ResponseCode.SUCCESS, list);
    }
}