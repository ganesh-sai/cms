package com.example.cms.filters;
import javax.servlet.*;
import java.io.IOException;

public class MyNewFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("The new Filter is called..!");
    }
}
