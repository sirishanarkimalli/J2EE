package jdbc;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;

import oracle.jdbc.rowset.OracleFilteredRowSet;

class HighSalaryEmployees implements Predicate {

	@Override
	public boolean evaluate(RowSet rs) {
		try {
			return rs.getInt("salary") >10000;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean evaluate(Object arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean evaluate(Object arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}

public class FilteredRowSetDemo {

	public static void main(String[] args) throws SQLException, IOException {

		FilteredRowSet frs = new OracleFilteredRowSet();
		frs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		frs.setUsername("hr");
		frs.setPassword("hr");

		frs.setCommand("select * from  employees");
		frs.execute();
		
		frs.setFilter(new HighSalaryEmployees());
		
		while(frs.next()){
			System.out.printf("%-35s  %7d\n",frs.getString("first_name"),frs.getInt("salary"));
		}

		frs.close();

	}

}
