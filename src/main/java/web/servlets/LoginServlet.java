package web.servlets;

import businessObjects.GameState;
import businessObjects.Message;
import businessObjects.User;
import web.helpers.IGameDataManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {}


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        IGameDataManagement gameContext = (IGameDataManagement) getServletContext().getAttribute("gameDataContext");

        List<Message> messages = new ArrayList<>();


        User user = gameContext.getUserByLogin(login.trim());
        //l'authentification de l'utilisateur s'il existe déja
        if(user!=null) {
            if (user.getPassword() == null || !user.getPassword().equals(login)) {
                messages.add(new Message("Login or password incorrect"));
                request.setAttribute("messages", messages);
                System.out.println("cas 1");
                //envoyer une vue
                getServletContext().getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(request, response);


            }

            else {
                GameState gameState = new GameState(user);

                //stocker l'etat de game dans la session
                request.getSession().setAttribute("gameState", gameState);

                //stocker l'authentification de l'utilisateur dans la session
                request.getSession().setAttribute("user", user);
                HashMap<Integer,Integer> dicesDic = new HashMap<>();


                request.getSession().setAttribute("dic",dicesDic);

                System.out.println("cas 2");
                //envoyer une vue
                getServletContext().getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);

            }

        } else {
            messages.add(new Message("Login or password incorrect"));
            request.setAttribute("messages", messages);
            //envoyer une vue
            System.out.println("cas 3");
            getServletContext().getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(request, response);


        }


    }


}
