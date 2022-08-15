package web.servlets;

import businessObjects.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import web.helpers.IGameDataManagement;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BESTcoreServlet", value = "/BESTcoreServlet")
public class BESTcoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        IGameDataManagement gameContext = (IGameDataManagement) getServletContext().getAttribute("gameDataContext");

        List<User> users = gameContext.getAllUsers();

        request.setAttribute("users", users);

        // On redirige vers la vue (redirection cotÃ© serveur)
        getServletContext().getRequestDispatcher("/WEB-INF/pages/bestScore.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
