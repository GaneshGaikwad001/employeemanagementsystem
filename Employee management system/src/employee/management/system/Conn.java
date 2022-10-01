
package employee.management.system;
import java.sql.*;

public class Conn {
    Connection c;
    Statement S;
    public Conn(){
        
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","Ganesh2001");
    S = c.createStatement();
}catch(Exception e){
    e.printStackTrace();
}
    }
}
