package jdbc;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException; 

public class SelectFromJobs {

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from jobs");
		while (rs.next()) {
			System.out.printf("%-6s %-35s %8d %8d\n", rs.getString("job_id"),
					rs.getString("job_title"), rs.getInt("min_salary"), rs.getInt("max_salary"));
		}
		rs.close();
		st.close();
		con.close();

	}
}