
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField txtusername,txtpassword;
    Login(){
       getContentPane().setBackground(Color.white);
       setLayout(null);
       
       JLabel lblusername = new JLabel("USERNAME");
       lblusername.setBounds(40,40,100,30);
       add(lblusername);
       
       txtusername = new JTextField();
       txtusername.setBounds(160,40,200,30);
       add(txtusername);
       
       JLabel lblpassword = new JLabel("PASSWORD");
       lblpassword.setBounds(40,90,100,30);
       add(lblpassword);
       
       txtpassword = new JTextField();
       txtpassword.setBounds(160,90,200,30);
       add(txtpassword);
       
       JButton login = new JButton("LOGIN");
       login.setBounds(180,160,150,30);
       login.setForeground(Color.white);
       login.setBackground(Color.black);
       login.addActionListener(this);
       add(login);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
               
       setSize(600,300); 
       setLocation(450,200);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
           String username = txtusername.getText();
           String password = txtpassword.getText();
           Conn c = new Conn();
           String query = "select * from login where username = '"+username+"'and password = '"+password+"'";
           
          ResultSet rs = c.S.executeQuery(query);
          if(rs.next()){
              setVisible(false);
              new Home();
          }else{
              JOptionPane.showMessageDialog(null, "invalid username or password");
              setVisible(false);
                  }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new Login();
    }
}