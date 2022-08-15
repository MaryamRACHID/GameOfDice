package web.dataAccessObjects;

import businessObjects.User;
import web.helpers.IGameDataManagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Singleton
public class GameDatabaseManagement implements IGameDataManagement {
    private static GameDatabaseManagement instance;
    private String connex = "jdbc:mysql://localhost:3306/gamedb?user=root&password=";

    //pseudo-Constructeur
    private GameDatabaseManagement() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //methode qui instance
    synchronized public static GameDatabaseManagement getInstance() {
        if (instance == null) {
            instance = new GameDatabaseManagement();
        }
        return instance;
    }

    public List<User> getAllUsers() {
        Connection con = null;
        List<User> list = new ArrayList<>();

        try {
            con = DriverManager.getConnection(connex);

            try {
                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery("select * from Utilisateur");

                while (rs.next()) {
                    User u = new User(rs.getString("nom"), rs.getString("prenom"), rs.getString("login"),
                            rs.getString("password"), rs.getDouble("score"), rs.getDouble("bestScore"), 0);
                    list.add(u);

                }
            } finally {
                if (con != null) {
                    con.close();
                }
            }
        } catch (SQLException e) {
        }
        return list;

    }

    public void updateScore(User user) {

        Connection con = null;
        try {
            con = DriverManager.getConnection(connex);

            try {

                PreparedStatement pstmt = con.prepareStatement("UPDATE Utilisateur set bestScore = ? where login=?");
                pstmt.setDouble(1, user.getBestScore());
                pstmt.setString(2, user.getLogin());
                pstmt.executeUpdate();

            } finally {
                if (con != null) {
                    con.close();
                }
            }
        } catch (SQLException e) {
        }

    }

    public void insertUser(User user) {
        Connection con = null;
        try {
            con = DriverManager.getConnection(connex);

            try {

                PreparedStatement pstmt = con.prepareStatement(
                        "insert into Utilisateur ( nom,  prenom,  login,  password,  score,  bestScore) values ( ?,  ?,  ?,  ?,  ?,  ?)");
                pstmt.setString(1, user.getNom());
                pstmt.setString(2, user.getPrenom());
                pstmt.setString(3, user.getLogin());
                pstmt.setString(4, user.getPassword());
                pstmt.setDouble(5, user.getScore());
                pstmt.setDouble(6, user.getBestScore());

                pstmt.executeUpdate();

            } finally {
                if (con != null) {
                    con.close();
                }
            }
        } catch (SQLException e) {
        }

    }


    public User getUserByLogin(String login) {
        Connection con = null;
        List<User> list = new ArrayList<User>();

        try {
            con = DriverManager.getConnection(connex);
            System.out.println("connecté");

            try {


                PreparedStatement pstmt = con.prepareStatement("select * from Utilisateur where login =?");
                pstmt.setString(1, login);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    User u = new User(rs.getString("nom"), rs.getString("prenom"), rs.getString("login"),
                            rs.getString("password"), rs.getDouble("score"), rs.getDouble("bestScore"), 0);
                    list.add(u);

                }

            } finally {
                if (con != null) {
                    con.close();
                }
            }
        } catch (SQLException e) {
        }
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

}
