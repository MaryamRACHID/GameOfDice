package web.helpers;


import businessObjects.User;

import java.util.List;

public interface IGameDataManagement {

    public List<User> getAllUsers();
    public void updateScore(User user);
    public void insertUser(User user);
    public User getUserByLogin(String login);


}
