package com.newtechcollege.cms.config;

import com.newtechcollege.cms.myexception.MyException;
import com.newtechcollege.cms.util.RedisUtil;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
public class Filter extends OncePerRequestFilter {

    @Resource
    private RedisUtil redisUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if ("/admin/login".equals(requestURI)){
            doFilter(request, response, filterChain);
        }else {
//            String token = request.getHeader("token");
////            String val = (String) Jwt.getVal(token, "linke", "adminname");
////            String redisToken = (String) redisUtil.get(val);
////            if (token.equals(redisToken)) {
////                System.out.println("token验证成功");
////                doFilter(request, response, filterChain);
////            } else {
////                System.out.println("未登录");
////                throw new MyException("请登录！");
////            }
            if(true){
                throw new MyException("请登录！");
            }
        }
    }
}
