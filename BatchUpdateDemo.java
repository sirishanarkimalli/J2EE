package jdbc;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdateDemo {
	public static void main(String args[]) throws SQLException {
		try (Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			try {
				stmt.addBatch("update employees set salary=salary+2000 where salary>10000");
				stmt.addBatch("update employees set salary=salary+1000 where salary<10000");
				int[] uc = stmt.executeBatch();
				// execute batch
				con.commit();
//				for (int i = 0; i < uc.length; i++) {
//					System.out.println(i + ":" + uc[i]);
//				}// end of for loop
			} catch (BatchUpdateException ex) {
				System.out.println("Batch Update Exception:" + ex.getMessage());
				con.rollback();
			}
			
		}
	}
}
