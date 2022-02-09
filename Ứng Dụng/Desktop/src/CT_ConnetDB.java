
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CT_ConnetDB 
{
    
    java.sql.Connection conn;
    String dbURL = "jdbc:sqlserver://localhost;databaseName=DuAn;user=sa;password=sa";
    Connection ConnetDB()
    {
        try
	{ 
            conn = DriverManager.getConnection(dbURL);
            //conn=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-EP9DH3T:1433; databaseName =DuAn","sa","sa");             
        }
        catch (SQLException e)
        {
            System.err.println("KẾT NỐI THẤT BẠI CT");
        }
        return conn; 
    }
}
