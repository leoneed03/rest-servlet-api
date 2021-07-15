package org.app.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

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
//        System.out.println(request.getServerName());
//
//        Enumeration<String> name = request.getParameterNames();
//
//        while (name.hasMoreElements()) {
//            String stringName = name.nextElement();
//            System.out.println(request.getParameter(stringName));
//        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        config = null;
    }
}
