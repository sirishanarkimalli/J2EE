package jdbc;

import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import oracle.jdbc.rowset.OracleCachedRowSet;

//Program to display employee with the given job_id
public class ListJobsWithId {
	public static void main(String[] args) throws SQLException {
		CachedRowSet crs = new OracleCachedRowSet();
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		crs.setUsername("hr");
		crs.setPassword("hr");

		//
		crs.setCommand("Select * from employees where job_id=?");
		crs.setString(1, "SA_REP");
		crs.execute();
		
		while (crs.next()) {
			System.out.println(crs.getString("first_name"));
		}

	}

}
