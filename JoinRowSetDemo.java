package jdbc;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleJoinRowSet;

public class JoinRowSetDemo {

	public static void main(String[] args) throws SQLException {
		CachedRowSet crs1 = new OracleCachedRowSet();
		crs1.setUrl("jdbc:oracle:thin:@localhost:1521:Xe");
		crs1.setUsername("hr");
		crs1.setPassword("hr");

		crs1.setCommand("select job_id, job_title from jobs");
		crs1.execute();

		CachedRowSet crs2 = new OracleCachedRowSet();
		crs2.setUrl("jdbc:oracle:thin:@localhost:1521:Xe");
		crs2.setUsername("hr");
		crs2.setPassword("hr");

		crs2.setCommand("select job_id, first_name,salary from employees");
		crs2.execute();

		JoinRowSet jrs = new OracleJoinRowSet();
		jrs.addRowSet(crs1, "job_id");
		jrs.addRowSet(crs2, "job_id");

		while (jrs.next()) {
			System.out.printf("%-10s %-35s %-15s %-6d\n", jrs.getString(1),
					jrs.getString(2),jrs.getString(3), jrs.getInt(4));

		}
	}

}
