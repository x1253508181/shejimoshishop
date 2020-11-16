package com.itheima.shop.interceptor;

import com.itheima.shop.user.SessionShare;
import com.itheima.shop.user.ThreadSession;
import com.itheima.shop.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.interceptor.AuthorizationInterceptor
 ****/
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    private ThreadSession threadSession;

    /****
     * 将用户会话存储到ThreadLocal中
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            //获取令牌
            String authorization = request.getHeader("token");
            //解析令牌
            if(!StringUtils.isEmpty(authorization)){
                Map<String, Object> tokenMap = JwtTokenUtil.parseToken(authorization);
                //封装用户身份信息，存储到ThreadLocal中，供当前线程共享使用
                //1.封装需要共享的信息[Session]
                //2.创建一个对象继承封装信息，每次共享该对象 (不需要共享，则可以创建另外一个对象继承它)
                //3.创建共享管理对象，实现共享信息的增加、获取、移除功能
                threadSession.add(new SessionShare(
                      tokenMap.get("username").toString(),
                      tokenMap.get("name").toString(),
                      tokenMap.get("sex").toString(),
                      tokenMap.get("role").toString(),
                      Integer.valueOf(tokenMap.get("level").toString())
                ));
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //输出令牌校验失败
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print("身份校验失败!");
        response.getWriter().close();
        return false;
    }

    /**
     * 移除会话信息
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //移除用户信息
        threadSession.remove();
    }
}
