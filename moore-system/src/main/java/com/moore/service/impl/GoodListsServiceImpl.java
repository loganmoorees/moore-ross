package com.moore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.moore.mapper.product.GoodListsMapper;
import com.moore.model.entity.product.GoodListsEntity;
import com.moore.model.vo.product.GoodListsVO;
import com.moore.service.product.IGoodListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 货品分类实现类
 *
 * @author Moore
 * @since 2020-07-14
 */
@Service
public class GoodListsServiceImpl implements IGoodListsService {

    @Autowired
    GoodListsMapper goodListsMapper;

    /**
     * 获取货品菜单栏
     *
     * @return
     */
    @Override
    public List<GoodListsVO> getGoodsMenu() {
        // 拿到所有菜单
        List<GoodListsEntity> goodListsEntities = goodListsMapper.selectList(new QueryWrapper<>());

        List<GoodListsEntity> oneList = new ArrayList<>();
        // 取一级菜单
        goodListsEntities.forEach(e -> {

        });

        return null;
    }
}
