package es.pue.myvueling.model.persistence.daos.impl.jdbc;

import es.pue.myvueling.model.business.entities.planning.Color;
import es.pue.myvueling.model.persistence.daos.contracts.ColorDAO;
import es.pue.myvueling.model.persistence.exceptions.DAOException;
import es.pue.myvueling.model.persistence.utilities.JDBCUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorJDBCDAO implements ColorDAO {

    @Override
    public Color getColorById(long id) throws DAOException {

        Color color = null;
        
        try (Connection connection = JDBCUtils.openConnection();
             CallableStatement sentSQL = connection.prepareCall("CALL getColorById(?)")) {
           
            sentSQL.setLong(1, id);
            try (ResultSet reader = sentSQL.executeQuery()) {
                if (reader.next()) {
                    // ORM: [--,--,--,--,--,--] -----> []Color
                    color = JDBCUtils.getColor(reader);
                }            
            }
        }
        catch (SQLException | IOException ex) {
            //Logger
            throw new DAOException(ex);
        }
        
        return color;
    }
    
    @Override
    public List<Color> getColors() throws DAOException {
        
        List<Color> colors = new ArrayList<>();
        
        try (Connection connection = JDBCUtils.openConnection();
             CallableStatement sentSQL = connection.prepareCall("CALL getColors()");
             ResultSet reader = sentSQL.executeQuery()) {
            
                while (reader.next()) {
                    // ORM: [--,--,--,--,--,--] -----> []Color
                    colors.add(JDBCUtils.getColor(reader));
                }            
        }
        catch (SQLException | IOException ex) {
            //Logger
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
