package g1.lmscom.infinite.java.lms;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchLeave {
	public static void main(String[] args) {
		int Eid;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id   ");
		Eid = sc.nextInt();
		try {
			LeaveDetails leave = new LeaveDetailsDAO().searchLeave(Eid);
			if (leave!=null) {
				System.out.println(leave);
			} else {
				System.out.println("*** Records Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
