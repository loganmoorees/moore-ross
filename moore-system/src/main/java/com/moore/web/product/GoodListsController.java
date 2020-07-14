package com.moore.web.product;

import com.moore.model.vo.product.GoodListsVO;
import com.moore.service.product.IGoodListsService;
import io.swagger.annotations.ApiOperation;
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
public class GoodListsController {

    /**
     * 货品分类服务层
     */
    @Autowired
    IGoodListsService goodListsService;


    @GetMapping("/goodMenu")
    @ApiOperation("获取货品菜单栏")
    public List<GoodListsVO> getGoodsMenu() {
        goodListsService.getGoodsMenu();
        return null;
    }
}
