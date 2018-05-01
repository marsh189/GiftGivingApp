package com.hci.marsh189.giftgiving;// Use the JDBC driver
import java.sql.*;

public class SQLDatabaseConnection {

    String connectionString;
    Connection connection;
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public SQLDatabaseConnection() {
        connectionString =
                "jdbc:sqlserver://DESKTOP-6LLEGJJ.GiftGiving.windows.net:1433;"
                        + "database=AdventureWorks;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "hostNameInCertificate=*.database.windows.net;"
                        + "loginTimeout=30;";

        // Declare the JDBC objects.
        connection = null;
    }

    public ResultSet executeSelect(String queryString)
    {

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(connectionString);

            // Create and execute a SELECT SQL statement.
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryString);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            // Close the connections after the data has been handled.
            if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}
            if (statement != null) try { statement.close(); } catch(Exception e) {}
            if (connection != null) try { connection.close(); } catch(Exception e) {}
        }
        return resultSet;
    }

    public void executeUpdate(String queryString)
    {

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(connectionString);

            // Create and execute a SELECT SQL statement.
            statement = connection.createStatement();
            statement.executeUpdate(queryString);
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}