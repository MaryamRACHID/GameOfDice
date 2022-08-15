package web.listeners;

import businessObjects.User;
import jakarta.servlet.annotation.WebListener;
import web.helpers.DataManagementFactory;
import web.helpers.IGameDataManagement;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebListener
public class AppInitialisation implements ServletContextListener {

    public AppInitialisation() {
    }

    public void contextInitialized(ServletContextEvent event) {
        ServletContext cont = event.getServletContext();

        String type = cont.getInitParameter("type_stockage");
        System.out.println(type);

        IGameDataManagement gameDataContext = DataManagementFactory.getFactory(type, cont);


        cont.setAttribute("gameDataContext", gameDataContext);

        List<User> userList = Collections.synchronizedList(new ArrayList<User>());

        cont.setAttribute("users", userList);

    }



}
