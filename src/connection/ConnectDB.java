/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agond
 */
public class ConnectDB{
    public static Connection conn = null;
    private static String server;
    private static String database;
    private static String username;
    private static String password;
    private static int port;
    private static String strConnect;
    
    public ConnectDB() throws ClassNotFoundException, SQLException, IOException{
        readConfig();
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }
    
    public void connect() throws SQLException {
        conn = DriverManager.getConnection(strConnect);
        System.out.print("Database is connected\n");
    }

    public void disconnect() throws SQLException {
        conn.close();
        System.out.println("Disconnected Database\n");
    }
    
    public void connect(String context) throws SQLException {
        conn = DriverManager.getConnection(strConnect);
        try {
            System.out.print("Database is connected by " + context + "\n");
        } catch (java.lang.NullPointerException e) {
        }        
    }

    public void disconnect(String context) throws SQLException {
        conn.close();
        try {
            System.out.println("Disconnected Database by " + context + "\n");
        } catch (java.lang.NullPointerException e) {
        }        
    }
    
    private static void readConfig() throws IOException {
        String fileURL = "src\\connection\\DB.properties";
        Properties properties = new Properties();
        properties.load(new FileInputStream(fileURL));
        server = properties.getProperty("DB_SERVER");
        database = properties.getProperty("DB_NAME");
        username = properties.getProperty("DB_USERNAME");
        password = properties.getProperty("DB_PASSWORD");
        port = Integer.parseInt(properties.getProperty("DB_PORT"));
        strConnect = "jdbc:sqlserver://"+server+":"+port+";databaseName="+database+";user="+username+";password="+password+";encrypt=true;trustServerCertificate=true";
    }
}