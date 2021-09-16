package G1.ExamAgent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AgentInsert {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int empno,premium,marital_status;
		String city,name;
		Gender gender=Gender.MALE;
		System.out.println("Enter Agent Id  ");
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
		city = sc.next();
		System.out.println("Enter Marital Status  ");
		marital_status = sc.nextInt();
		System.out.println("Enter premium   ");
		premium = sc.nextInt();
		String cmd = "insert into Agent(AgentID,Name,City,Gender,\r\n"
				+ "MaritalStatus,Premium) values(?,?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam",
					"root","root");
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setInt(1, empno);
			pst.setString(2, name);
			pst.setString(4, gender.toString());
			pst.setString(3, city);
			pst.setInt(5, marital_status);
			pst.setInt(6, premium);
			pst.executeUpdate();
			System.out.println("*** Record Inserted ***");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
