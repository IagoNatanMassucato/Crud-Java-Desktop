/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


/**
 *
 * @author Microsoft
 */
public class UserController {
    Connection conn;
    public ResultSet userAuthentication(User objUser){
       conn = new ConnectionDataBase().connectionBD();
        try {
            String sql = "SELECT * FROM tbuser WHERE nameuser = ? AND passworduser = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objUser.getName());
            pstm.setString(2, objUser.getPassawod());
            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null,"CONTROLLER, UserController, método userAuthentication() => "+  error);
            return null;
        }
    }
}
