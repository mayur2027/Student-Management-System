
package studentmanagementsystem;
import java.sql.*;

public class connect {
    public Connection con;
 
    public connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mayur","mayur","1234");
        }catch(Exception e) {
            System.out.println("failed");
            e.printStackTrace();
            
        }
    }

    
}
