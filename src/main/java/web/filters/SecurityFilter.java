package web.filters;

import jakarta.servlet.annotation.*;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.log4j.Logger;


@WebFilter(filterName = "SecurityFilter")
public class SecurityFilter implements Filter {

    private static final String CONNEXION_PAGE = "/WEB-INF/pages/Login.jsp";

    private final Logger LOGGER;
    public SecurityFilter() {
        LOGGER = Logger.getLogger(SecurityFilter.class);
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {


        HttpServletRequest rq = (HttpServletRequest) request;

        HttpSession session = rq.getSession();

        if (session.getAttribute("user") == null) {

            rq.getRequestDispatcher(CONNEXION_PAGE).forward(request, response);

            return;

        } else {
            chain.doFilter(request, response);

        }

    }

}