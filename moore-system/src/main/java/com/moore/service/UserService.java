package com.moore.service;

import com.moore.model.entity.UserEntity;

public interface UserService {

    /**
     * 注册
     *
     * @return
     */
    String register(UserEntity userEntity);

    /**
     * 登录
     *
     * @param userEntity
     * @return
     */
    String login(UserEntity userEntity);

    /**
     * 根据对象检查是否是唯一数据
     *
     * @param userEntity
     * @return
     */
    Boolean getOne(UserEntity userEntity);
}
