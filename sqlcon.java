import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class sqlcon {
    Connection c;
    Statement s;
    public sqlcon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/final_tcr","root","25324269");
            s =c.createStatement();

        }catch(Exception e){
            System.out.println("database error" + e);
        }
    }
}
