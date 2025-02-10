/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import java.sql.*;


public class Conn {                                                  
    Connection c;                                                     //CREATE OBJ OF CONN. INTERFACE
    Statement s;                                                      //CREATE OBJ. OF STAT. INTERFACE
    Conn(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");                    //REGISTER THE DRIVER
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "Vinayak18@");    //CREATE CONN. STRING TO CONNECT WITH DB
        s = c.createStatement();                                                                                      // FOR EXECUTING MYSQL QUERY
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
    }
    
}
