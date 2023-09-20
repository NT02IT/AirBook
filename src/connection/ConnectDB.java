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
    protected static Connection conn = null;
    private static String server;
    private static String database;
    private static String username;
    private static String password;
    private static int port;
    private static String strConnect;
    
    public ConnectDB() throws ClassNotFoundException, SQLException{
        try {
            readConfig();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            strConnect = "jdbc:sqlserver://"+server+":"+port+";databaseName="+database+";user="+username+";password="+password+";encrypt=true;trustServerCertificate=true";
            conn = DriverManager.getConnection(strConnect);
//            System.out.print("Ket noi DB thanh cong");
        } catch (IOException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.print("Ket noi DB that bai");
        }
    }
    
    public void connect() throws SQLException {
        conn = DriverManager.getConnection(strConnect);
//        System.out.print("Ket noi DB thanh cong");
    }

    public void disconnect() throws SQLException {
        conn.close();
//        System.out.println("Ngat ket noi DB thanh cong");
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
    }
}