package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Updates the phone number of the given employee id.
 */
public class UpdateEmployee {

	
	public static void main(String[] args)throws SQLException {
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
		Statement st= con.createStatement();
		int count= st.executeUpdate("update employees set phone_number=\'515.111.4568\' where employee_id=101");
		System.out.printf("Updated %d rows in employee",count);
		st.close();
		con.close();
		
	}

}
