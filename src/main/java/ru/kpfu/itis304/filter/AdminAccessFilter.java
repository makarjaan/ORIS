package ru.kpfu.itis304.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(urlPatterns = "/users")
public class AdminAccessFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(AdminAccessFilter.class.getName());




    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession(false);

        if (session != null) {
            String username = (String) session.getAttribute("user");
            if ("admin".equalsIgnoreCase(username)) {
                chain.doFilter(request, response);
                LOG.info("Администратор имеет доступ к странице users.");
            } else {
                ((HttpServletResponse) response).sendRedirect("/main.jsp");
                LOG.info("Попытка доступа к странице users не администратором: " + username);
            }
        } else {
            ((HttpServletResponse) response).sendRedirect("/login");
            LOG.info("Попытка доступа к странице users без сессии.");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}