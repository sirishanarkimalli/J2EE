package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertIntoJobs {

	public static void main(String[] args) throws SQLException{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
		
		Scanner s= new Scanner(System.in);
		System.out.println("Enter job_id");
		String id=s.nextLine();
		System.out.println("Enter job_title");
		String title=s.nextLine();
		System.out.println("Enter min_salary");
		int min_sal=s.nextInt();
		System.out.println("Enter max_salary");
		int max_sal=s.nextInt();
		
		PreparedStatement pst= con.prepareStatement("insert into jobs values(?, ?,?,?)");
		pst.setString(1,id);
		pst.setString(2,title);
		pst.setInt(3,min_sal);
		pst.setInt(4,max_sal);
		
		int count =pst.executeUpdate();
		
		System.out.println("Inserted row(S) "+count);
//		pst.rollback();
		
		pst.close();
		con.close();
		s.close();
		
				
		

	}

}
