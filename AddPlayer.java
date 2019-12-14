package jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
//create table players (player varchar2(20) primary key, photo blob);
public class AddPlayer {
	public static void main(String args[]) {
		try (Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {
			// Take input from user
			Scanner s = new Scanner(System.in);
			System.out.print("Enter player name:");
			String playername = s.nextLine();
			System.out.print("Enter Photo filename:");
			String photofilename = s.nextLine();
			con.setAutoCommit(false);
			PreparedStatement ps = con
					.prepareStatement("insert into players  values(?,?)");
			File picfile = new File(photofilename);
			FileInputStream fis = new FileInputStream(picfile);
			ps.setString(1, playername);
			ps.setBinaryStream(2, fis, (int) picfile.length());
			ps.executeUpdate();
			con.commit();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
