package web.helpers;

import businessObjects.User;

import jakarta.servlet.ServletContext;
import java.util.List;

public class GameContextManagement implements IGameDataManagement {

        //instance
        private static GameContextManagement instance;
        private ServletContext context;

        //pseudo-constructeur
        private GameContextManagement (ServletContext context) {
            this.context=context;
        }

        //methode qui permet l'instanciation d'un singleton
        synchronized public static final GameContextManagement getInstance(ServletContext context) {
            if (instance==null) {
                instance = new GameContextManagement(context);
            }
            return instance;
        }

        @Override
        public List<User> getAllUsers() {
            return (List<User>) context.getAttribute("users");
        }

        @Override
        public void updateScore(User user) {
            List<User> users = getAllUsers();
            for (User it : users) {
                if (it.getLogin().equals(user.getLogin())) {
                    it.setBestScore(user.getBestScore());
                    break;
                };
            }
        }

        @Override
        public void insertUser(User user) {
            List<User> users = (List<User>) context.getAttribute("users");
            users.add(user);
        }

        @Override
        public User getUserByLogin(String login) {
            List<User> users = getAllUsers();
            if(!users.isEmpty()){
                for (User it : users) {
                    System.out.println(it);
                    if (it.getLogin().equals(login)) {
                        return it;
                    }
                }
            }


            return null;
        }



    }

