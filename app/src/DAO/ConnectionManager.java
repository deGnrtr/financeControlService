package src.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private final String URL = "jdbc:postgresql://localhost:5432/main_data";
    Properties props = new Properties();
    {
        props.setProperty("user", "manager");
        props.setProperty("password", "123454321");
        props.setProperty("ssl", "false");
    }
    private static ConnectionManager manager;

    private ConnectionManager(){}

    public static ConnectionManager getManager(){
        if (manager == null){
            manager = new ConnectionManager();
        }
        return manager;
    }

    public Connection createConnection() throws SQLException{
        return DriverManager.getConnection(URL, props);
    }



}
