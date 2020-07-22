package com.moore.filter;

import com.auth0.jwt.interfaces.Claim;
import com.moore.model.entity.UserEntity;
import com.moore.service.UserService;
import com.moore.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        Map<String, Claim> map = JwtUtil.validToken(token);
        if (map.size() == 0) {
            return false;
        }

        Map<String, Claim> hashMap = JwtUtil.validToken(token);
        Claim id = hashMap.get("userId");
        if (id == null) {
            return false;
        }
        Integer userId = id.asInt();
        Claim name = hashMap.get("userName");
        if (name == null) {
            return false;
        }
        String userName = name.asString();
        UserEntity entity = UserEntity.builder()
                .id(userId)
                .userName(userName)
                .build();
        Boolean flag = userService.getOne(entity);
        if (!flag) {
            return false;
        }
        return true;
    }
}
