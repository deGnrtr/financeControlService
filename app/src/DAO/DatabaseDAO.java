package src.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class DatabaseDAO<E> implements Dao<E>{
    protected Connection connection;

    protected void setConnection(Connection connection){
        this.connection = connection;
    }

    @Override
    public abstract E findById(int id) throws DAOException;

    @Override
    public abstract E findByName(String name) throws DAOException;

    @Override
    public List<E> findAll() throws DAOException{
        try (Statement statement = connection.createStatement()){
            String query = "SELECT ";
            List<E> result = new ArrayList<>();
            return result;
        } catch (SQLException e){
            throw new DAOException("Can't create the Statement object", e);
        }
    }

    @Override
    public void create(E entity) throws DAOException{

    }

    @Override
    public abstract void update(E entity, String...changes) throws DAOException;

    @Override
    public void delete(E entity) throws DAOException{

    }

    @Override
    public void delete(int id) throws DAOException{

    }

    protected void closeStatement(Statement statement) throws DAOException{
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e){
                throw new DAOException("Can't close the Statement object", e);
            }
        }
    }

}
