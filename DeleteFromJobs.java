package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteFromJobs {

	public static void main(String[] args) throws SQLException{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
		
		Scanner s= new Scanner(System.in);
		System.out.println("Enter job_id");
		String id=s.nextLine();
		
		
		PreparedStatement pst= con.prepareStatement("delete from jobs where job_id=?");
		pst.setString(1,id);
		
		int count =pst.executeUpdate();
		
		System.out.printf("Deleted %d row ",count);
//		pst.rollback();
		
		pst.close();
		con.close();
		s.close();
	}

}
