package AdmissionMonitor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentId {

	public static int currId()
	{
		int userId=10;
		ResultSet res;
		try {
			res = Jdbc.st.executeQuery("select studentId from studentDetails ");
			while (res.next())
			{
				userId=res.getInt("studentId");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userId;
	}
	public static void main(String[] args) {
		
	}

}
