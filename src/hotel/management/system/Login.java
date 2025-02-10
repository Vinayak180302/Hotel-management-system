
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    JTextField username;                   //MAKE A GLOBALLY SCOPED TO ACCESSED IN ANY CLASS
    JPasswordField password;
    JButton login, cancel;
    Login(){
        getContentPane().setBackground(Color.WHITE);   //bg color to the frame
        
        setLayout(null);                               // want to put our own label thats why null
        JLabel user = new JLabel("Username");           //create label by named user which has value username 
        user.setBounds(40, 20, 100, 30);                // to place exactly where on the frame 
        add(user);                                      //add user on the frame
        
        username = new JTextField();          // to create text field for username
        username.setBounds(150, 20, 150, 30);
        add(username);
        
        
        JLabel pass = new JLabel("Password");                 //to create label for password
        pass.setBounds(40, 70, 100, 30);
        add(pass);
        
        password = new JPasswordField();               // to create text field for password
        password.setBounds(150, 70, 150, 30);
        add(password);
        
        login = new JButton("Login");                 // to create a login button 
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);                  //FOR BTN CLICK ACTION
        add(login);
        
        cancel = new JButton("Cancel");               // to create cancel button
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);              //FOR BTN CLICK ACTION
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);
        
        setBounds(500, 200, 600, 300);                      // FOR ENTIRE LOGIN FRAME
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){           //OVERRIDE CLASS 
        if(ae.getSource() == login){                       // IF USER CLICK ON LOGIN
            String user = username.getText();             
            String pass = password.getText();               //STORE USER INPUT VALUES
            
            // ESTABLISH CONN. WITH DB TO COMPARE VALUES IN DB AND USR INPUT
            try{ 
                Conn c = new Conn();
                
                String query = "select * from login where username = '" + user + "'and password ='" + pass + "'";   //TO STORE COMPARE VALUE IN QUERY
                
                ResultSet rs = c.s.executeQuery(query);                    // STORE DATA IN QUERY INTO RS
                
                if(rs.next()){     // IF DATA MATCH WITH DB
                    setVisible(false);
                    new Dashboard();
                }
                else{              // IF DATA DON'T MATCH
                    JOptionPane.showMessageDialog(null, "Invaild username or password");   
                    setVisible(false);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
                
        } 
            else if(ae.getSource() == cancel){                    //IF USER CLICK ON CANCEL
           setVisible(false); 
        }
    }
    public static void main(String[] args){
        
        new Login();
        
    }
    
}