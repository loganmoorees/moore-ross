package com.moore.service.product;

import com.baomidou.mybatisplus.extension.service.IService;
import com.moore.model.entity.product.GoodListsEntity;
import com.moore.model.vo.product.GoodListsVO;

import java.util.List;

/**
 * 货品分类服务类
 *
 * @author Moore
 * @since 2020-07-14
 */
public interface IGoodListsService {

    List<GoodListsVO> getGoodsMenu();
}
