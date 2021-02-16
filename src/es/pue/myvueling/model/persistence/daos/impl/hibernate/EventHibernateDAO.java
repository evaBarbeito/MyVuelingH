package es.pue.myvueling.model.persistence.daos.impl.hibernate;

import es.pue.myvueling.model.business.entities.planning.Event;
import es.pue.myvueling.model.persistence.daos.contracts.EventDAO;
import es.pue.myvueling.model.persistence.exceptions.DAOException;
import es.pue.myvueling.model.persistence.utilities.HibernateUtils;
import java.util.List;
import org.hibernate.HibernateException;


public class EventHibernateDAO implements EventDAO {

    @Override
    public Event getEventById(long id) throws DAOException {
        
        Event event = null;
        try (var session = HibernateUtils.getSessionFactory().openSession()) {            
            var hql = session.createQuery("FROM Event AS e WHERE e.id = :id");
            hql.setParameter("id", id);
            event = (Event)hql.uniqueResult();            
        }
        catch (HibernateException ex) {
            throw new DAOException(ex);
        }
        return event;
    }

    @Override
    public List<Event> getEvents() throws DAOException {
        
        List<Event> events = null;
        try (var session = HibernateUtils.getSessionFactory().openSession()) {            
            var hql = session.createQuery("FROM Event AS e");
            events = hql.list();            
        }
        catch (HibernateException ex) {
            throw new DAOException(ex);
        }
        return events;
    }

    @Override
    public List<Event> getEvents(int offset, int count) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> getEvents(boolean visible) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> getEvents(boolean visible, int offset, int count) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> getEvents(String searchTerm) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> getEvents(String searchTerm, int offset, int count) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> getEvents(boolean visible, String searchTerm) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> getEvents(boolean visible, String searchTerm, int offset, int count) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> getCurrentWeekEvents() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> getCurrentMonthEvents() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
