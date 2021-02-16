package es.pue.myvueling.views;

import es.pue.myvueling.model.business.entities.planning.Color;
import es.pue.myvueling.model.business.entities.planning.Event;
import es.pue.myvueling.model.persistence.daos.impl.hibernate.ColorHibernateDAO;
import es.pue.myvueling.model.persistence.daos.impl.hibernate.EventHibernateDAO;
import es.pue.myvueling.model.persistence.daos.utilities.DAOFactory;
import es.pue.myvueling.model.persistence.daos.impl.jdbc.ColorJDBCDAO;
import es.pue.myvueling.model.persistence.daos.impl.jdbc.EventJDBCDAO;
import es.pue.myvueling.model.persistence.exceptions.DAOException;
import es.pue.myvueling.model.persistence.utilities.HibernateUtils;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Application {

    public static void main(String[] args) {
        HibernateUtils.initialize("config/hibernate.cfg.xml");
        
        Scanner stdin = new Scanner(System.in);
        
        //Locale.setDefault(new Locale("en", "US"));
        //var bundle = ResourceBundle.getBundle("es.pue.myvueling.i18n.messages");
        //System.out.printf("%s: %s %n", bundle.getString("menu.language"), Locale.getDefault().getDisplayName());
        
        var colorDAO = DAOFactory.getColorDAO();
        var eventDAO = DAOFactory.getEventDAO();
        
        try {
            Color c = colorDAO.getColorById(5);
            if (c != null) {
                System.out.println(c.toString());
            }
            
        } catch (DAOException ex) {
            System.out.printf("Error:: %s %n", ex.getMessage());
        }
        
        System.out.println("Pulsa una tecla para continuar");
        stdin.nextLine();
        
        try {
            List<Color> colors = colorDAO.getColors();
            for (Color c : colors) {
                System.out.println(c.toString());
            }
            
        } catch (DAOException ex) {
            System.out.printf("Error:: %s %n", ex.getMessage());
        }
        
        System.out.println("Pulsa una tecla para continuar");
        stdin.nextLine();
        
        try {
            Event e = eventDAO.getEventById(5);
            if (e != null) {
                System.out.println(e.toString());
            }
            
        } catch (DAOException ex) {
            System.out.printf("Error:: %s %n", ex.getMessage());
        }
        
        System.out.println("Pulsa una tecla para continuar");
        stdin.nextLine();
        
        try {
            List<Event> events = eventDAO.getEvents();
            for (Event e : events) {
                System.out.println(e.toString());
            }
        } catch (DAOException ex) {
            System.out.printf("Error:: %s %n", ex.getMessage());
        }
        
        System.out.println("Pulsa una tecla para continuar");
        stdin.nextLine();
        
        
        //HibernateUtils.stop();
    }
}
