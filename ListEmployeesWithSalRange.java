package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.FilteredRowSet;
import oracle.jdbc.rowset.OracleFilteredRowSet;


public class ListEmployeesWithSalRange {

	public static void main(String[] args) throws SQLException {
		FilteredRowSet frs = new OracleFilteredRowSet();
		frs.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		frs.setUsername("hr");
		frs.setPassword("hr");

		Scanner s = new Scanner(System.in);

		System.out.println("Enter min salary");
		int min = s.nextInt();
		System.out.println("Enter max salary");
		int max = s.nextInt();
		
		frs.setCommand("select * from employees where salary between ? and ?");
		frs.setInt(1,min);
		frs.setInt(2,max);		
		frs.execute();

//		frs.setFilter(new SalaryRange());
		while (frs.next())
			System.out.println(frs.getString("first_name") + ":"
					+ frs.getInt("salary"));
		frs.close();
	}

}
