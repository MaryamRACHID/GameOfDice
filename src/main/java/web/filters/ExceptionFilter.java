package web.filters;

import businessObjects.Message;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebFilter(filterName = "ExceptionFilter")
public class ExceptionFilter implements Filter {

    Logger LOGGER = Logger.getLogger(getClass());

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        LOGGER.debug("Execution du filtre ExceptionFilter");
        try {

            chain.doFilter(request, response);

        } catch (Exception e) {
            List<Message> list = new ArrayList<>();
            list.add(new Message("Une erreur est survenue veuillez consulter le fichier journal pour plus de dÃ©tails"));
            request.setAttribute("messages", list);
            request.getServletContext().getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);

        }
    }

}
