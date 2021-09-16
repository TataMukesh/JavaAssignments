package G1.ExamAgent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AgentUpdate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int empno,basic,marital_status;
		String dept,name;
		Gender gender=Gender.MALE;
		System.out.println("Enter Agent ID  ");
		empno=sc.nextInt();
		System.out.println("Enter Name  ");
		name=sc.next();
		System.out.println("Enter Gender ");
		String gen = sc.next();
		if (gen.toUpperCase().equals("MALE")) {
			gender = Gender.MALE;
		}
		if (gen.toUpperCase().equals("FEMALE")) {
			gender=Gender.FEMALE;
		}
		System.out.println("Enter City  ");
		dept = sc.next();
		System.out.println("Enter Marital Status  ");
		marital_status = sc.nextInt();
		System.out.println("Enter Basic   ");
		basic = sc.nextInt();
		String cmd = "update Agent set AgentID=?, Name=?, City=?, GENDER=?,"
				+ " MaritalStatus=?, Premium=? where AgentID=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam",
					"root","root");
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setString(2, name);
			pst.setString(4, gender.toString());
			pst.setString(3, dept);
			pst.setInt(5, marital_status);
			pst.setInt(6, basic);
			pst.setInt(1, empno);
			pst.setInt(7, empno);
			pst.executeUpdate();
			System.out.println("*** Record Updated ***");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
