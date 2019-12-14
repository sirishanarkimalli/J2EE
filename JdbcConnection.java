package jdbc;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws SQLException {
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
//		System.out.println(con.getClass());
//		Class connectionImplClass=con.getClass();
//		Method[] methods=con.getClass().getMethods();
//	   System.out.println(methods.length);
//		for(Method  m : methods){
//			System.out.println(m.getName());
//		}
		
		System.out.println("Connected");
		con.close();
	}

}
