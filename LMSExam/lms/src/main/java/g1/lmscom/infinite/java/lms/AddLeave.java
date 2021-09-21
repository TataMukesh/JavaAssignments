package g1.lmscom.infinite.java.lms;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class AddLeave{
	public static void main(String[] args) {
		LeaveDetails leave = new LeaveDetails();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter EmployId   ");
		leave.setEmpId(sc.nextInt());
		
		
		System.out.println("Enter LeaveStartDate (yyyy-MM-dd)  ");
		leave.setLeaveStartDate(Date.valueOf(sc.next()));
		
		System.out.println("Enter LeaveEndDate (yyyy-MM-dd)   ");
		leave.setLeaveEndDate(Date.valueOf(sc.next()));
		
		System.out.println("Enter Leave Reason   ");
		leave.setLeaveReason(sc.next());
		
		try {
			System.out.println(new LeaveDetailsDAO().addLeave(leave));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
