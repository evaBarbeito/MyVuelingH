package es.pue.myvueling.model.persistence.daos.impl.hibernate;

import es.pue.myvueling.model.business.entities.planning.Color;
import es.pue.myvueling.model.persistence.daos.contracts.ColorDAO;
import es.pue.myvueling.model.persistence.exceptions.DAOException;
import es.pue.myvueling.model.persistence.utilities.HibernateUtils;
import java.util.List;
import org.hibernate.HibernateException;


public class ColorHibernateDAO implements ColorDAO {

    @Override
    public Color getColorById(long id) throws DAOException {
    
        Color color = null;
        
        try (var session = HibernateUtils.getSessionFactory().openSession()) {
            
            var hql = session.createQuery("FROM Color AS c WHERE c.id = :id");
            hql.setParameter("id", id);
            color = (Color)hql.uniqueResult();
            
        }
        catch (HibernateException ex) {
            throw new DAOException(ex);
        }
        
        return color;
    }

    @Override
    public List<Color> getColors() throws DAOException {
        List<Color> colors = null;
        
        try (var session = HibernateUtils.getSessionFactory().openSession()) {
            
            var hql = session.createQuery("FROM Color");
            colors = hql.list();
            
        }
        catch (HibernateException ex) {
            throw new DAOException(ex);
        }
        
        return colors;
    }

    @Override
    public List<Color> getColors(int offset, int count) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Color> getColors(String searchTerm) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Color> getColors(String searchTerm, int offset, int count) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
