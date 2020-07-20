package com.moore.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moore.product.model.entity.SeriesEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductTypeMapper extends BaseMapper<SeriesEntity> {
}
