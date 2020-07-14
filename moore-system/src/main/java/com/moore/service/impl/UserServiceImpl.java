package com.moore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.moore.mapper.UserMapper;
import com.moore.model.entity.UserEntity;
import com.moore.service.UserService;
import com.moore.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     *
     * @param userEntity
     * @return
     */
    @Override
    public String register(UserEntity userEntity) {
        String userName = userEntity.getUserName();
        UserEntity user = getUser(userName);

        if (user != null) {
            return "当前用户已经注册";
        }
        int insert = userMapper.insert(userEntity);
        if (insert != 0) {
            return "注册成功";
        }
        return null;
    }

    @Override
    public String login(UserEntity userEntity) {
        String userName = userEntity.getUserName();
        UserEntity user = getUser(userName);
        if (user == null) {
            return "false";
        } else if (userEntity.getPassword().equals(user.getPassword())) {
            String token = JwtUtil.createToken(user);
            return token;
        }
        return "false";
    }

    /**
     * 根据UserName获取User对象
     *
     * @param userName
     * @return
     */
    private UserEntity getUser(String userName) {
        UserEntity entity = UserEntity.builder()
                .userName(userName)
                .build();
        List<UserEntity> user = userMapper.selectList(new QueryWrapper<>(entity));
        if (user.size() == 0) {
            return new UserEntity();
        }
        return user.get(0);
    }

    /**
     * 根据对象检查是否存在此唯一数据
     *
     * @param userEntity
     * @return
     */
    public Boolean getOne(UserEntity userEntity) {
        List<UserEntity> userEntities = userMapper.selectList(new QueryWrapper<>(userEntity));
        if (userEntities.size() == 1) {
            return true;
        }
        return false;
    }
}
