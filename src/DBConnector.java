import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.util.Date;
import java.sql.*;

public class DBConnector {

	
public static void addTransaction(int userid, String type, String time, String amount) {
		try
	    {
	      // create a mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/test";
	      Class.forName(myDriver);
	      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
	    
	      

	      // the mysql insert statement
	      String query = " insert into transactions (user_id, timestamp, type, amount)"
	        + " values (?, ?, ?, ?)";

	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setInt (1, userid);
	      preparedStmt.setString(2, time);
	      preparedStmt.setString (3, type);
	      preparedStmt.setString(4, amount);

	      
	      
	  
	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
		
	}

	
public static void addUser(String userName, String password, String email, String student_id, String address, String contact_number )
	{
		try
	    {
	      // create a mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/test";
	      Class.forName(myDriver);
	      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
	    
	      

	      // the mysql insert statement
	      String query = " insert into users (username, password, email, student_id, address, contact_number)"
	        + " values (?, ?, ?, ?, ?, ?)";

	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString (1, userName);
	      preparedStmt.setString(2, password);
	      preparedStmt.setString (3, email);
	      preparedStmt.setString(4, student_id);
	      preparedStmt.setString (5, address);
	      preparedStmt.setString (6, contact_number);
	      
	      
	      
	  
	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	}
	
	
public static String getUserProfileName(String username) {
		try
	    {
	     
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/test";
	      Class.forName(myDriver);
	      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
	    
	      Statement m_Statement = (Statement) conn.createStatement();
	      String query = "SELECT * FROM `users` WHERE `username`='" + username + "'";

	      ResultSet m_ResultSet = m_Statement.executeQuery(query);
	      StringBuilder builder = new StringBuilder();
	      while (m_ResultSet.next()) 
	      {
	    	  //System.out.println(m_ResultSet.getString(2));
	    	  builder.append((m_ResultSet.getString(2)));
	    	  
	      }
	      System.out.println("Res - " + builder.toString());
	      conn.close();
	      
	      
	      return builder.toString();
	      
	       
	    }
	    catch (Exception f)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(f.getMessage());
	      return "failed";
	    }
		
	}
	
	
	
public static String getUserContact_number(String username) {
		try
	    {
	     
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/test";
	      Class.forName(myDriver);
	      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
	    
	      Statement m_Statement = (Statement) conn.createStatement();
	      String query = "SELECT * FROM `users` WHERE `username`='" + username + "'";

	      ResultSet m_ResultSet = m_Statement.executeQuery(query);
	      StringBuilder builder = new StringBuilder();
	      while (m_ResultSet.next()) 
	      {
	    	  //System.out.println(m_ResultSet.getString(2));
	    	  builder.append((m_ResultSet.getString(7)));
	    	  
	      }
	      System.out.println("Res - " + builder.toString());
	      conn.close();
	      
	      
	      return builder.toString();
	      
	       
	    }
	    catch (Exception f)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(f.getMessage());
	      return "failed";
	    }
		
	}
	
public static String getTransactions(String userid) {
		try
	    {
	     
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/test";
	      Class.forName(myDriver);
	      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
	    
	      Statement m_Statement = (Statement) conn.createStatement();
	      String query = "SELECT * FROM `transactions` WHERE `user_id`='" + userid + "'";

	      ResultSet m_ResultSet = m_Statement.executeQuery(query);
	      StringBuilder builder = new StringBuilder();
	      
	      builder.append("<html><table><tr><th>ID__</th>  <th>User ID__</th>  <th>Time__</th>  <th>Type__</th>  <th>Amount__</th></tr>");
	      while (m_ResultSet.next()) 
	      {
	    	  //System.out.println(m_ResultSet.getString(2));
	    	  builder.append("<tr>");
	    	  for(int i = 1; i<=5; i++)
	    	  {
	    		  builder.append("<td>" + m_ResultSet.getString(i) + "</td>");  
	    	  }
	    	  builder.append("</tr>");
	    	 
	    	  
	      }
	      builder.append("</table></html>");
	      System.out.println("Res - " + builder.toString());
	      conn.close();
	      
	      
	      return builder.toString();
	      
	       
	    }
	    catch (Exception f)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(f.getMessage());
	      return "failed";
	    }
		
		
	}
public static String getAmount(String userid)
{
	double amount = 0.0;
	try
    {
     
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/test";
      Class.forName(myDriver);
      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
    
      Statement m_Statement = (Statement) conn.createStatement();
      String query = "SELECT * FROM `transactions` WHERE `user_id`='" + userid + "'";

      ResultSet m_ResultSet = m_Statement.executeQuery(query);
      while (m_ResultSet.next()) 
      {
    	  //System.out.println(m_ResultSet.getString(2));
    	  String type = m_ResultSet.getString(4);
    	  String amm = m_ResultSet.getString(5);
    	  if(type.equals("Dr"))
    	  {
    		  amount -= Double.parseDouble(amm); 
    	  }
    	  else {
			amount += Double.parseDouble(amm);
		}
    	 
    	  
      }
     
      conn.close();
      
       
       
    }
    catch (Exception f)
    {
      System.err.println("Got an exception!");
      System.err.println(f.getMessage());
      return "failed";
    }

	return Double.toString(amount);
}


public static String getUserTransactions(String userid) {
	try
    {
     
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/test";
      Class.forName(myDriver);
      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
    
      Statement m_Statement = (Statement) conn.createStatement();
      String query = "SELECT * FROM `transactions` WHERE `user_id`='" + userid + "'";

      ResultSet m_ResultSet = m_Statement.executeQuery(query);
      StringBuilder builder = new StringBuilder();
      
      builder.append("<html><table><tr><th>ID__</th>  <th>User ID__</th>  <th>Time__</th>  <th>Type__</th>  <th>Amount__</th></tr>");
      while (m_ResultSet.next()) 
      {
    	  //System.out.println(m_ResultSet.getString(2));
    	  builder.append("<tr>");
    	  for(int i = 1; i<=5; i++)
    	  {
    		  builder.append("<td>" + m_ResultSet.getString(i) + "</td>");  
    	  }
    	  builder.append("</tr>");
    	 
    	  
      }
      builder.append("</table></html>");
      System.out.println("Res - " + builder.toString());
      conn.close();
      
      
      return builder.toString();
      
       
    }
    catch (Exception f)
    {
      System.err.println("Got an exception!");
      System.err.println(f.getMessage());
      return "failed";
    }
	
	
}




public static String getUserProfileEmail(String username) {
	try
    {
     
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/test";
      Class.forName(myDriver);
      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
    
      Statement m_Statement = (Statement) conn.createStatement();
      String query = "SELECT * FROM `users` WHERE `username`='" + username + "'";

      ResultSet m_ResultSet = m_Statement.executeQuery(query);
      StringBuilder builder = new StringBuilder();
      while (m_ResultSet.next()) 
      {
    	  //System.out.println(m_ResultSet.getString(2));
    	  builder.append((m_ResultSet.getString(4) ));
    	  
      }
      System.out.println("Res - " + builder.toString());
      conn.close();
      
      
      return builder.toString();
      
    }
    catch (Exception f)
    {
      System.err.println("Got an exception!");
      System.err.println(f.getMessage());
      return "failed";
    }
	
}


public static String getUserProfileID(String username) {
	try
    {
     
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/test";
      Class.forName(myDriver);
      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
    
      Statement m_Statement = (Statement) conn.createStatement();
      String query = "SELECT * FROM `users` WHERE `username`='" + username + "'";

      ResultSet m_ResultSet = m_Statement.executeQuery(query);
      StringBuilder builder = new StringBuilder();
      while (m_ResultSet.next()) 
      {
    	  //System.out.println(m_ResultSet.getString(2));
    	  builder.append((m_ResultSet.getString(1) ));
    	  
      }
      System.out.println("Res - " + builder.toString());
      conn.close();
      
      
      return builder.toString();
      
    }
    catch (Exception f)
    {
      System.err.println("Got an exception!");
      System.err.println(f.getMessage());
      return "failed";
    }
	
}


public static String getAllTransactions() 
{
	try
    {
     
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/test";
      Class.forName(myDriver);
      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
    
      Statement m_Statement = (Statement) conn.createStatement();
      String query = "SELECT * FROM `transactions`";
      ResultSet m_ResultSet = m_Statement.executeQuery(query);
      StringBuilder builder = new StringBuilder();
      
      builder.append("<html><table><tr><th>Serial______</th>  <th>User ID______</th>  <th>Time______</th>  <th>Type______</th>  <th>Amount______</th></tr>");
      while (m_ResultSet.next()) 
      {
    	  //System.out.println(m_ResultSet.getString(2));
    	  builder.append("<tr>");
    	  for(int i = 1; i<=5; i++)
    	  {
    		  builder.append("<td>" + m_ResultSet.getString(i) + "</td>");  
    	  }
    	  builder.append("</tr>");
    	 
    	  
      }
      builder.append("</table></html>");
      System.out.println("Res - " + builder.toString());
      conn.close();
      
      
      return builder.toString();
      
       
    }
    catch (Exception f)
    {
      System.err.println("Got an exception!");
      System.err.println(f.getMessage());
      return "failed";
    }	
	
}





public static String getAllTransactionsByAdmin() 
{
	try
    {
     
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/test";
      Class.forName(myDriver);
      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
    
      Statement m_Statement = (Statement) conn.createStatement();
      String query = "SELECT `amount`, `type`, `timestamp` FROM `transactions` WHERE `user_id`";
      ResultSet m_ResultSet = m_Statement.executeQuery(query);
      StringBuilder builder = new StringBuilder();
      
      builder.append("<html><table><tr><th>amount______</th>  <th>type______</th>  <th>Time______</th>  </tr>");
      while (m_ResultSet.next()) 
      {
    	  //System.out.println(m_ResultSet.getString(2));
    	  builder.append("<tr>");
    	  for(int i = 1; i<=3; i++)
    	  {
    		  builder.append("<td>" + m_ResultSet.getString(i) + "</td>");  
    	  }
    	  builder.append("</tr>");
    	 
    	  
      }
      builder.append("</table></html>");
      System.out.println("Res - " + builder.toString());
      conn.close();
      
      
      return builder.toString();
      
       
    }
    catch (Exception f)
    {
      System.err.println("Got an exception!");
      System.err.println(f.getMessage());
      return "failed";
    }	
	
}

public static String getUserProfileStudentID(String username) {
	try
    {
     
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/test";
      Class.forName(myDriver);
      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
    
      Statement m_Statement = (Statement) conn.createStatement();
      String query = "SELECT * FROM `users` WHERE `username`='" + username + "'";

      ResultSet m_ResultSet = m_Statement.executeQuery(query);
      StringBuilder builder = new StringBuilder();
      while (m_ResultSet.next()) 
      {
    	  //System.out.println(m_ResultSet.getString(2));
    	  builder.append((m_ResultSet.getString(5) ));
    	  
      }
      System.out.println("Res - " + builder.toString());
      conn.close();
      
      
      return builder.toString();
      
    }
    catch (Exception f)
    {
      System.err.println("Got an exception!");
      System.err.println(f.getMessage());
      return "failed";
    }
	
}


public static String getUserProfileAddress(String username) {
	try
    {
     
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/test";
      Class.forName(myDriver);
      Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "");
    
      Statement m_Statement = (Statement) conn.createStatement();
      String query = "SELECT * FROM `users` WHERE `username`='" + username + "'";

      ResultSet m_ResultSet = m_Statement.executeQuery(query);
      StringBuilder builder = new StringBuilder();
      while (m_ResultSet.next()) 
      {
    	  //System.out.println(m_ResultSet.getString(2));
    	  builder.append((m_ResultSet.getString(6) ));
    	  
      }
      System.out.println("Res - " + builder.toString());
      conn.close();
      
      
      return builder.toString();
      
    }
    catch (Exception f)
    {
      System.err.println("Got an exception!");
      System.err.println(f.getMessage());
      return "failed";
    }
	
}
}


