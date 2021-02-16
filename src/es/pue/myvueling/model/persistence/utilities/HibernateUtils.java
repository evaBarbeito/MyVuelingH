package es.pue.myvueling.model.persistence.utilities;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.LogManager;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


public final class HibernateUtils {

    //<editor-fold defaultstate="collapsed" desc="Atributos/Campos estáticos">
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor privado">
    private HibernateUtils() {
        
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos/Operaciónes estáticas">
    

    public static void initialize(String configFile) {
        LogManager.getLogManager().getLogger("").setLevel(Level.OFF);
        
        serviceRegistry = new StandardServiceRegistryBuilder().configure(new File(configFile)).build();
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
    }
    
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void stop() {
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }
    
    //</editor-fold>
}
