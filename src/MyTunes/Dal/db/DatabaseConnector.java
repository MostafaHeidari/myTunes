package MyTunes.dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {


    private static final String PROP_FILE = "Database.Properties";
    private SQLServerDataSource dataSource;

    public DatabaseConnector() throws IOException {
        Properties databaseProperties = new Properties();
        databaseProperties.load(new FileInputStream("data/Database.properties"));
        dataSource = new SQLServerDataSource();
        dataSource.setServerName(databaseProperties.getProperty("SERVERNAME"));
        dataSource.setDatabaseName(databaseProperties.getProperty("DATABASENAME"));
        dataSource.setUser(databaseProperties.getProperty("USER"));
        dataSource.setPassword(databaseProperties.getProperty("PASSWORD"));
    }

    public Connection getConnection() throws SQLServerException, SQLServerException {
        return dataSource.getConnection();
    }

}
