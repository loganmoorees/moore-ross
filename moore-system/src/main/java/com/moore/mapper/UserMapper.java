package com.moore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moore.model.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
