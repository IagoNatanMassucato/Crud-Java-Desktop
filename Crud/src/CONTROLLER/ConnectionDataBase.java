/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Microsoft
 */
public class ConnectionDataBase {
     public Connection connectionBD(){
        Connection conn = null;
        try {
            String url;
            url = "jdbc:mysql://localhost:3306/bdcrud?user=root&password=21012004";
            conn = DriverManager.getConnection(url);
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "ConnectionDataBase MySQL, método connectionBD() => "+error.getMessage(), "Comunique o TI", 0);
        }
        return conn;
    }
}
