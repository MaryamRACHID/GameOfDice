package web.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeconnectServlet", value = "/DeconnectServlet")
public class DeconnectServlet extends HttpServlet {

    public DeconnectServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Invalider la session
        request.getSession().invalidate();

        // On redirige vers login
        getServletContext().getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(request, response);

        return;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
