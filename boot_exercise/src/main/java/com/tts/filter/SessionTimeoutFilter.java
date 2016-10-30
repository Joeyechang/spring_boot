package com.tts.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by phoenix on 2016/10/19.
 */
@WebFilter(urlPatterns = "/hello", filterName = "FilterHello")
@Component
public class SessionTimeoutFilter extends OncePerRequestFilter {
    private static Log log = LogFactory.getLog(SessionTimeoutFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        /*log.info("is Async Dispatch:" + isAsyncDispatch(request));
        log.info("is Async Started:" + isAsyncStarted(request));
        log.info("shouldNotFilter:" + shouldNotFilter(request));*/
        filterChain.doFilter(request, response);
    }
}
