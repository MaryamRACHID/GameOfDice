package web.servlets;

import businessObjects.Message;
import businessObjects.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.helpers.GameContextManagement;
import org.apache.log4j.Logger;
import web.helpers.IGameDataManagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Tarik BOUDAA
 *
 *         Ecole Nationale des Sciences Appliquées Al Hoceima
 *
 */
public class UserManagementServlet extends HttpServlet {
    private Logger LOGGER = Logger.getLogger(String.valueOf(getClass()));

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String createUserFormPage = "/WEB-INF/pages/Inscription.jsp";

        ServletContext cntx = getServletContext();

        // On affiche le formulaire d'ajout
        if (request.getParameter("create") != null) {
            cntx.getRequestDispatcher(createUserFormPage).forward(request, response);
            // fin
            return;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errorPage = "/WEB-INF/pages/error.jsp";
        String okPage = "/WEB-INF/pages/operationOK.jsp";
        String Login = "/WEB-INF/pages/Login.jsp";
        String home = "/WEB-INF/pages/home.jsp";
        ServletContext cntx = getServletContext();

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = new User(nom, prenom, login, password, 0, 0);

        IGameDataManagement gameContext = (IGameDataManagement) getServletContext().getAttribute("gameDataContext");

        List<Message> messages = new ArrayList<Message>();

        try {

            // On teste si un utilisateur existe avec le login choisit

            if (gameContext.getUserByLogin(login) != null) {

                // Ajouter des message d'erreur dans la requete
                messages.add(new Message("Login existe déjà"));
                request.setAttribute("messages", messages);

                cntx.getRequestDispatcher(errorPage).forward(request, response);
                return;

            }

            // On ajoute l'utilisateur

            gameContext.insertUser(user);

            // On redirige vers la page login avec un message de succès
            messages.add(new Message("Utilisateur correctement ajouté"));
            // On enregistre la liste des messages comme attributs de requete
            request.setAttribute("messages", messages);
            LOGGER.debug("l'utilisateur est crée" );
            // On redirige vers la vue
            cntx.getRequestDispatcher(Login).forward(request, response);


            // Arret
            return;
        } catch (Exception ex) {
            // En cas d'erreur on redirige vers la vue qui va afficher les erreurs
            messages.add(new Message("Une erreur est survenue"));
            cntx.getRequestDispatcher(errorPage).forward(request, response);

            return;

        }

    }

}