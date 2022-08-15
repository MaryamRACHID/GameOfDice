package businessObjects;

import java.util.ArrayList;
import java.util.List;
import businessObjects.User;


//dans cette class on va decrire l'état de jeu pour un utilisateur
public class GameState {
    //attribut de class
    private User user;
    private boolean gameOver = false;
    //journal
    private List<Message> messages = new ArrayList<Message>();


    //gameInitial pour reinitialiser le jeu
    public void gameInitial() {
        gameOver = false;
        messages = new ArrayList<Message>();
        user.setScore(0);
        user.setCompteurLancer(0);
    }

    //ajouter un message au journal
    public void addMessage(Message message) {
        messages.add(message);
    }

    //Constructeur 01
    public GameState(User user) {
        this.user = user;
    }

    //toString Overriding
    @Override
    public String toString() {
        return "GameState [user=" + user + ", gameOver=" + gameOver + ", messages=" + messages + "]";
    }

    //Getters&Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }



}
