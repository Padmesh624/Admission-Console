 package AdmissionMonitor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class Jdbc 
{
	static Connection con;
	static Statement st;
	static
	{
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admissionmonitor","root","padmesh123");
			st=con.createStatement();
			con.setAutoCommit(false);
		}
		catch(Exception e) 
		{
		  System.out.println("There is an error, check it");
		}
	}
	
}
