package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDemo {

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
		
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the new salary ");
		double sal=s.nextDouble();
		
		System.out.println("Enter the employee id to be updated ");
		int empId=s.nextInt();
		
		PreparedStatement pst = con
				.prepareStatement("update employees set salary=? where employee_id=?");
		pst.setDouble(1,sal);
		pst.setInt(2,empId);
		
		int count = pst.executeUpdate();
		System.out.println("updated rows " + count);
		
		
		s.close();
		pst.close();
		con.close();
		
	}

}
