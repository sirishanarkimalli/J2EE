package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleOCIDriverDemo {

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {
		//Loading driver into memory.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:oci8:@","hr", "hr");
		System.out.println("Connected using OCI Driver");
		con.close();

	}

}
