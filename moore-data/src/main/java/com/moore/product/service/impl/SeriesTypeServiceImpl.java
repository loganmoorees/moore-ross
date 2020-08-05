package com.moore.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.moore.common.utils.BeanUtil;
import com.moore.product.mapper.SeriesTypeMapper;
import com.moore.product.model.entity.SeriesTypeEntity;
import com.moore.product.model.vo.SeriesTypeVo;
import com.moore.product.service.SeriesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesTypeServiceImpl implements SeriesTypeService {

    @Autowired
    private SeriesTypeMapper seriesTypeMapper;

    /**
     * 获取物料期限类别
     *
     * @return
     */
    @Override
    public List<SeriesTypeVo> getProductDeadline() {
        List<SeriesTypeEntity> entities = seriesTypeMapper.selectList(new QueryWrapper<>());
        List<SeriesTypeVo> list = BeanUtil.copyList(entities, SeriesTypeVo.class);
        return list;
    }
}
