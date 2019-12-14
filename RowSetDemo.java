package jdbc;


import java.sql.SQLException;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class RowSetDemo {

	public static void main(String[] args)throws SQLException{
		
		CachedRowSet crs= new OracleCachedRowSet();
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		crs.setUsername("hr");
		crs.setPassword("hr");
		
		crs.setCommand("select * from jobs");
		crs.execute();
		 
		crs.absolute(3);
		while (crs.next()) {
			System.out.printf("%-6s %-35s %8d %8d\n", crs.getString(1),
					crs.getString(2), crs.getInt(3), crs.getInt(4));
		}
		crs.close();
		
	}

}
