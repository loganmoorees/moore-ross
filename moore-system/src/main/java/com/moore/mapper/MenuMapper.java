package com.moore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moore.model.entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper extends BaseMapper<MenuEntity> {
}
