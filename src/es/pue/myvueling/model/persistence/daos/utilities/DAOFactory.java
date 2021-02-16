package es.pue.myvueling.model.persistence.daos.utilities;

import es.pue.myvueling.model.persistence.daos.contracts.ColorDAO;
import es.pue.myvueling.model.persistence.daos.contracts.EventDAO;
import es.pue.myvueling.model.persistence.daos.impl.hibernate.ColorHibernateDAO;
import es.pue.myvueling.model.persistence.daos.impl.hibernate.EventHibernateDAO;
import es.pue.myvueling.model.persistence.daos.impl.jdbc.ColorJDBCDAO;
import es.pue.myvueling.model.persistence.daos.impl.jdbc.EventJDBCDAO;


public final class DAOFactory {
    
    //<editor-fold defaultstate="collapsed" desc="Atributos/Campos">
    private static ColorDAO colorDAO;
    private static EventDAO eventDAO;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos/Operaciones">
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    private DAOFactory() {
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Factory Methods">
    public static ColorDAO getColorDAO() {
        if (colorDAO == null) {
            colorDAO = new ColorHibernateDAO();
        }
        return colorDAO;
    }
    
    public static EventDAO getEventDAO() {
        if (eventDAO == null) {
            eventDAO = new EventHibernateDAO();
        }
        return eventDAO;
    }
    //</editor-fold>
    
    //</editor-fold>
    
}
