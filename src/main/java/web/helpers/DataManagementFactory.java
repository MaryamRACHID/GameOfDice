package web.helpers;

import jakarta.servlet.ServletContext;
import web.dataAccessObjects.GameDatabaseManagement;


public class DataManagementFactory {

    public static IGameDataManagement getFactory(String Type, ServletContext context) {

        if(!"mysql".equals(Type))
        {return GameContextManagement.getInstance(context);
        }
        return GameDatabaseManagement.getInstance();

    }

}
