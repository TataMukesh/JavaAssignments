package G1.ExamAgent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AgentSearch {
	public static void main(String[] args) {
		int empno;
		System.out.println("Enter Agent No  ");
		Scanner sc = new Scanner(System.in);
		empno=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam",
					"root","root");
			String cmd = "select * from Agent where AgentID=?";
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setInt(1, empno);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println("Agent ID   " +rs.getInt("AgentID"));
				System.out.println("Agent Name  " +rs.getString("Name"));
				System.out.println("Gender   " +rs.getString("GENDER"));
				System.out.println("City  " +rs.getString("City"));
				System.out.println("Marital Status  " +rs.getString("MaritalStatus"));
				System.out.println("Premium   " +rs.getInt("Premium"));
			} else {
				System.out.println("*** Record Not Found ***");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
