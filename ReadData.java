
import java.sql.*;

Ivory Coast (Cote d'Ivoire) [CI]

public class ReadData {
    public static void main(String[] args) throws Exception {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:cities.db");
        Statement stat = conn.createStatement();
	Statement stat2 = conn.createStatement();
        int i =1;
        ResultSet rs = stat.executeQuery("select DISTINCT country from cities ;");
        while (rs.next()) 
	{
		    System.out.println(i+"name = " + rs.getString("country"));
		   // System.out.println("job = " + rs.getString("locale_name"));
		    ResultSet rsc = stat2.executeQuery("select name from cities where country="+"'"+rs.getString("country")+"';" );
		while (rsc.next())
		{
			    System.out.println("	city = " + rsc.getString("name"));

		}
	i++;
	
        }
        rs.close();
	//rsc.close();
        conn.close();
    }
  }


