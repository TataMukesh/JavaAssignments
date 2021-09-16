package G1.ExamAgent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgentShow {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam",
					"root","root");
			String cmd = "select * from Agent";
			PreparedStatement pst = con.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println("Agent ID   " +rs.getInt("AgentID"));
				System.out.println("Agent Name  " +rs.getString("Name"));
				System.out.println("Gender   " +rs.getString("GENDER"));
				System.out.println("City  " +rs.getString("City"));
				System.out.println("Marital Status  " +rs.getString("MaritalStatus"));
				System.out.println("Premium   " +rs.getInt("Premium"));
				System.out.println("--------------------------------------------");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
