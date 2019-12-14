package jdbc;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleWebRowSet;

public class OracleWebRowSetDemo {

	public static void main(String[] args)throws SQLException,IOException{
		
		OracleWebRowSet ors= new OracleWebRowSet();
		ors.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ors.setUsername("hr");
		ors.setPassword("hr");
		
		ors.setCommand("select * from jobs");
		ors.execute();
		 
		FileWriter fw= new FileWriter("C:\\test\\jobs.xml");
		//writes to xml 
		ors.writeXml(fw);
		
		ors.close();
		
	}

}
