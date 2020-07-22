package com.moore.filter;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.interfaces.Claim;
import com.moore.model.entity.UserEntity;
import com.moore.service.UserService;
import com.moore.utils.JwtUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Configuration
public class AuthFilter extends ZuulFilter {

    private static final String INVALID_TOKEN = "invalid token";

    @Autowired
    UserService userService;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        // 获取上下文以及Request
        String uri = request.getRequestURI();
        System.out.println("--------------获取URL： " + uri + "-------------");
        if (uri.equals("/login")) {
            return false;
        }
        return true;
    }

    /**
     * token认证
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        System.out.println("----------------进入网关-----------------");
        String token = request.getHeader("token");
        if (StrUtil.isEmpty(token)) {
            setUnauthorizedResponse(context);
        }
        Map<String, Claim> map = JwtUtil.validToken(token);
        if (map.size() == 0) {
            setUnauthorizedResponse(context);
        }

        Map<String, Claim> hashMap = JwtUtil.validToken(token);
        Claim id = hashMap.get("userId");
        Integer userId = 0;
        if (id == null) {
            setUnauthorizedResponse(context);
        } else {
            userId = id.asInt();
        }
        Claim name = hashMap.get("userName");
        String userName = "";
        if (name == null) {
            setUnauthorizedResponse(context);
        } else
            userName = name.asString();
        UserEntity entity = UserEntity.builder()
                .id(userId)
                .userName(userName)
                .build();
        Boolean flag = userService.getOne(entity);
        if (!flag) {
            setUnauthorizedResponse(context);
        }
        return null;
    }

    /**
     * 请求失败
     *
     * @param context
     */
    private void setUnauthorizedResponse(RequestContext context) {
        context.setSendZuulResponse(false);
        context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        context.getResponse().setContentType("text/html;charset=utf-8");
        String failed = "认证失败，请重新登录";
        context.setResponseBody(failed);
    }
}