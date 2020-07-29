package com.moore.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.moore.common.utils.BeanUtil;
import com.moore.product.mapper.ProductTypeMapper;
import com.moore.product.model.entity.SeriesEntity;
import com.moore.product.model.vo.SeriesVo;
import com.moore.product.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 货品分类服务层实现类
 *
 * @author Moore
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    ProductTypeMapper productTypeMapper;

    public List<SeriesVo> getProductTypeMenu() {
        // 获取一级菜单
        QueryWrapper<SeriesEntity> wrapper = new QueryWrapper<SeriesEntity>().eq("parentId", "0");
        List<SeriesEntity> menus = productTypeMapper.selectList(wrapper);
        List<SeriesVo> menuVos = new ArrayList<>();
        // 递归获取子菜单
        menus.forEach(e -> {
            SeriesVo seriesVO = SeriesVo.builder()
                    .seriesId(e.getSeriesId())
                    .treeId(e.getTreeId())
                    .name(e.getName())
                    .isModify(e.getIsModify())
                    .finSeriesId(e.getFinSeriesId())
                    .isQuo(e.getIsQuo())
                    .key(e.getName())
                    .matClass(e.getMatClass())
                    .build();
            menuVos.add(seriesVO);
        });

        // 递归获取子菜单
        List<SeriesVo> seriesVos = getSonMenus(menuVos);
        return seriesVos;
    }

    /**
     * 递归获取子菜单
     *
     * @param menuVos
     * @return
     */
    private List<SeriesVo> getSonMenus(List<SeriesVo> menuVos) {
        menuVos.forEach(e -> {
            QueryWrapper<SeriesEntity> queryWrapper = new QueryWrapper<SeriesEntity>().eq("parentId", e.getTreeId());
            List<SeriesEntity> seriesEntities = productTypeMapper.selectList(queryWrapper);
            if (seriesEntities.size() != 0) {
                List<SeriesVo> list = BeanUtil.copyList(seriesEntities, SeriesVo.class);
                list.forEach(d -> {
                    d.setKey(d.getName());
                });
                SeriesVo vo = SeriesVo.builder()
                        .seriesId(e.getTreeId())
                        .treeId("000")
                        .name("新增节点")
                        .key("新增节点")
                        .build();
                list.add(vo);
                e.setChildMenu(list);
                getSonMenus(e.getChildMenu());
            }
        });
        return menuVos;
    }
}
