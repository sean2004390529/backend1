package com.sean.config;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@WebFilter(urlPatterns = "/*")
public class CorsFilter implements Filter{

	@Override
    public void init(FilterConfig arg0) throws ServletException {
    }
	
	@Override
    public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain) throws IOException, ServletException {

		HttpServletResponse response = (HttpServletResponse) res;

        // 指定允许其他域名访问
        response.setHeader("Access-Control-Allow-Origin", "http://goods.seanhobby.top:8000");
        // 响应类型
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        // 响应头设置
        response.setHeader("Access-Control-Allow-Headers", "token,Content-Type,Access-Control-Allow-Origin,Access-Control-Allow-Methods,Access-Control-Max-Age,authorization");
        response.setHeader("Access-Control-Max-Age", "3600");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
