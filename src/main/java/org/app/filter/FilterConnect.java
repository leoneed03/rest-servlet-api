package org.app.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class FilterConnect implements Filter {
    private FilterConfig config;

    @Override
    public void init(FilterConfig config) {
        this.config = config;

        System.out.println("INIT FILTER!!!");
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        System.out.println("FILTER REQUEST");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        System.out.println("__Method:" + httpServletRequest.getMethod());
        System.out.println("_____URL:" + httpServletRequest.getRequestURL());
        System.out.println("_____URI:" + httpServletRequest.getRequestURI());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        config = null;
    }
}
