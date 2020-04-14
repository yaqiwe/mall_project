package com.yaqiwe.mall.interceptor;

import com.yaqiwe.mall.exception.MallException;
import com.yaqiwe.mall.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author yaqiwe
 * @Date 2020/4/14 16:39
 * @Version 1.0
 * 校验请求中的jwt
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String hander = request.getHeader("Authorization");
        if (hander == null || hander.isEmpty()) {
            //未找到token
            throw new MallException("请先登录");
        } else if (!hander.startsWith("Bearer ")) {
            //token 不符合规则
            throw new MallException("令牌不正确");
        } else {
            String token = hander.substring(7);
            try {
                Claims claims = jwtUtil.parseJWT(token);
                request.setAttribute("userName", (String) claims.getSubject());
                String roles = (String) claims.get("roles");
                if (roles != null && roles.equals("admin")) {       //管理员
                    request.setAttribute("claims_admin", claims.getId());
                }
                if (roles != null && roles.equals("user")) {    //用户
                    request.setAttribute("claims_user", claims.getId());
                }
                if (roles != null && roles.equals("SuperAdmin")) {      //超级管理员
                    request.setAttribute("claims_super_admin", claims.getId());
                }
                return true;
            } catch (Exception e) {
                throw new MallException("登录过期请重新登录");
            }
        }
    }


}
