package airlinemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
    Connection c;
    Statement s;

    public DatabaseConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem","root","Sengupta@2003");
            s = c.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
