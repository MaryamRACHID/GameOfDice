package web.servlets;

import businessObjects.GameState;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ReinitGameServlet", value = "/ReinitGameServlet")

public class ReinitGameServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        GameState gs = (GameState) session.getAttribute("gameState");

        if (gs != null) {

            gs.gameInitial();
        }

        // reinit old result avec une valeur impossible pour le dÃ©
        session.setAttribute("old_result", -1);

        getServletContext().getRequestDispatcher("/WEB-INF/pages/homepage.jsp").forward(request, response);

        return;

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
