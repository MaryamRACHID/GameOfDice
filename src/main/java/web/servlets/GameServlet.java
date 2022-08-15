package web.servlets;

import businessObjects.GameState;
import businessObjects.Message;
import businessObjects.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import web.helpers.IGameDataManagement;

import java.io.IOException;
import java.util.*;

@WebServlet(name = "GameServlet", value = "/GameServlet")
public class GameServlet extends HttpServlet {

    public GameServlet() { }

    protected void play(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        IGameDataManagement gameContext = (IGameDataManagement) getServletContext().getAttribute("gameDataContext");

        GameState gameSate = (GameState) session.getAttribute("gameState");


        int choice = Integer.parseInt(request.getParameter("dice"));
        HashMap<Integer,Integer> dicesDic = (HashMap<Integer, Integer>) session.getAttribute("dic");



        //***********************************

        if (user.getCompteurLancer() == 3) {

            if (!gameSate.isGameOver()) {
                System.out.println("partie terminée avec succés");
                if (user.getScore() > user.getBestScore()) {
                    user.setBestScore(user.getScore());
                    gameContext.updateScore(user);
                }
                dicesDic.clear();

            }
            gameSate.setGameOver(true);
            getServletContext().getRequestDispatcher("/WEB-INF/pages/bestScore.jsp").forward(request, response);
            return;

        } else {

                if (choice>0 && choice<4){
                    if(!dicesDic.containsKey(choice)){
                        int value = new Random().nextInt(1, 7);
                        dicesDic.put(choice,value);
                        System.out.println("je suis à l'intervalle");
                    } else {
                        System.out.println("je suis lancé deux fois");
                        user.setScore(-1);
                        if (user.getScore() > user.getBestScore()) {
                            user.setBestScore(user.getScore());
                            gameContext.updateScore(user);
                        }
                        dicesDic.clear();
                        gameSate.setGameOver(true);
                        getServletContext().getRequestDispatcher("/WEB-INF/pages/bestScore.jsp").forward(request, response);

                        return;

                    }

                }else
                {
                    System.out.println("je suis pas dans l'intervalle");
                    user.setScore(0);
                    gameContext.updateScore(user);
                    gameSate.setGameOver(true);
                    getServletContext().getRequestDispatcher("/WEB-INF/pages/bestScore.jsp").forward(request, response);
                    return;
                }
                if (choice==1){
                    if(dicesDic.get(1)==6){
                        System.out.println("je suis -le six- éliminé");
                        user.setScore(0);
                        if (user.getScore() > user.getBestScore()) {
                            user.setBestScore(user.getScore());
                            gameContext.updateScore(user);
                        }
                        dicesDic.clear();
                        gameSate.setGameOver(true);
                        getServletContext().getRequestDispatcher("/WEB-INF/pages/bestScore.jsp").forward(request, response);
                        return;
                    }

                }
                for (Map.Entry<Integer, Integer> entry : dicesDic.entrySet()) {
                    if (entry.getValue()!=0){
                        if ((choice>entry.getKey() && dicesDic.get(choice)<= entry.getValue())
                                || (choice<entry.getKey() && dicesDic.get(choice)>=entry.getValue())){
                            System.out.println("je suis plus grand!" + dicesDic.get(choice));

                            user.setScore(0);
                            if (user.getScore() > user.getBestScore()) {
                                user.setBestScore(user.getScore());
                                gameContext.updateScore(user);
                            }
                            dicesDic.clear();
                            gameSate.setGameOver(true);
                            getServletContext().getRequestDispatcher("/WEB-INF/pages/bestScore.jsp").forward(request, response);
                            return;
                        }
                    }
                    }


            // on stocke le rÃ©sultat obtenu dans le dernier lancer
            user.incrementLance();
            user.setScore(user.getScore() + dicesDic.get(choice));
            gameContext.updateScore(user);
            System.out.println(dicesDic.get(choice));
            System.out.println("je passe normale"+choice);
            if (user.getCompteurLancer()==3){
                getServletContext().getRequestDispatcher("/WEB-INF/pages/bestScore.jsp").forward(request, response);
            }else {
                getServletContext().getRequestDispatcher("/WEB-INF/pages/homepage.jsp").forward(request, response);

            }

            // Fin
            return;
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        play(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        play(request, response);

    }

}
