/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author hp
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class DBConnection {
    private Connection con;
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hr_scheme?zeroDateTimeBehavior=convertToNull", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error = "+ e.getMessage());
        }
        return con;
    }
    
}
