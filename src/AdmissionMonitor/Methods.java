  package AdmissionMonitor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class Methods {
	public static void display() {
		System.out.println();
		System.out.println("                         WELCOME");
		System.out.println("                         -------");
		System.out.println("                    1.TO SHOW DEPARTMENT DETAILS");
		System.out.println();
		System.out.println("                    2.TO SHOW STAFF DETAILS");
		System.out.println();
		System.out.println("                    3.TO SHOW SCHOLARSHIP DETAILS");
		System.out.println();
		System.out.println("                    4.FOR OFFICE USE");
		System.out.println();
		System.out.println("    ----To quit the operation anywhere in the program, Press [9] ----");
		System.out.println();
		
	}
	public static void details()
	{
		System.out.println();
		System.out.println("                    11.To Put Admission");
		System.out.println();
		System.out.println("                    12.To Cancel Admission");
		System.out.println();
		System.out.println("                    13.Show Student Details");
		System.out.println();
		System.out.println("                    14.Show Admission Status");
		System.out.println();
		System.out.println("                    15.Show Department Status");
		System.out.println();
		System.out.println("                    16.Show Fees Collection");
	}
	public static void staffDetails() {

		System.out.println("StaffId  StaffName      StaffMobileNo   StaffEmail");
		System.out.println("-------  ---------      -------------   ----------");
		ResultSet rs;
		try {
			rs = Jdbc.st.executeQuery("Select * from staffDetails");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"      "+rs.getString(2)+"      "+rs.getString(3)+"      "+rs.getString(4));
				System.out.println();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	public static  void departmentDetails()
	{
		System.out.println("DeptId  DeptName  DeptFees    SeatsAllocated   SeatsFilled   SeatsBlocked  SeatsAvailable");
		System.out.println("------  --------  --------    --------------   -----------   ------------  --------------");
		
	    ResultSet rs;
		try {
			rs = Jdbc.st.executeQuery("Select * from departmentDetails");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"      "+rs.getString(2)+"      "+rs.getString(3)+"            "+rs.getString(4)+"                "+rs.getString(5)+"            "+rs.getString(6)+"             "+rs.getString(7));
				System.out.println();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void update(int p,int q, int r,String s,int t,String u)
	{
		try {
			PreparedStatement update=Jdbc.con. prepareStatement("insert into admissionStatus values (?,?,?,?,?,?)");
			update.setInt(1,p);
			update.setInt(2,q);
			update.setInt(3,r);
			update.setString(4,s);
			update.setInt(5,t);
			update.setString(6,u);
			update.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static  int twoNumber(String s1)
	{
		int num=0;
		int cnt=0;
		String  str="";
		for (int i=0;i<s1.length();i++)
		{
			if ((int)(s1.charAt(i))>=48 && (int)(s1.charAt(i))<=57)
			{
				str+=s1.charAt(i);
				cnt+=1;
			}
			else
			{
				break;
			}
		}
		if(cnt!=s1.length())
		{
			
		}
		else 
		{
			num=Integer.parseInt(str);
			
		}
		return num;
	}
	public static void main(String[] args) {
		 Scanner sc= new Scanner (System.in);
	}

}
