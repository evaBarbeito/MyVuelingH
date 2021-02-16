package es.pue.myvueling.model.persistence.daos.impl.jdbc;

import es.pue.myvueling.model.business.entities.planning.Color;
import es.pue.myvueling.model.business.entities.planning.Event;
import es.pue.myvueling.model.persistence.daos.contracts.EventDAO;
import es.pue.myvueling.model.persistence.exceptions.DAOException;
import es.pue.myvueling.model.persistence.utilities.JDBCUtils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class EventJDBCDAO implements EventDAO {

    @Override
    public Event getEventById(long id) throws DAOException {
   
        Event event = null;
    
        try(var connection = JDBCUtils.openConnection();
            var sql = connection.prepareCall("CALL getEventById(?)")) {
            
            sql.setLong(1, id);
            try(var reader = sql.executeQuery()) {
                
                if (reader.next()) {
                    //[-,-,-,-,-,] ---->[] (Mapeo ORM)
                    event = JDBCUtils.getEvent(reader);
                }
            }
        }
        catch (SQLException | IOException ex) {
            throw new DAOException(ex);
        }
        
        return event;
    }

    @Override
    public List<Event> getEvents() throws DAOException {
    
        List<Event> events = new ArrayList<>();
        
        try(var connection = JDBCUtils.openConnection();
            var sql = connection.prepareCall("CALL getEvents()");
            var reader = sql.executeQuery()) {
            
            while (reader.next()) {
                //[-,-,-,-,-,] ---->[] (Mapeo ORM)
                events.add(JDBCUtils.getEvent(reader));
            }            
        }
        catch (SQLException | IOException ex) {
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
