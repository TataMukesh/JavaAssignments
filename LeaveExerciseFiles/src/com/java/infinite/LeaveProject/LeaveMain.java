package com.java.infinite.LeaveProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class LeaveMain {
	static Scanner sc=new Scanner(System.in);
	
	public static void addLeave() throws LeaveException, ParseException  {
		Leave leave = new Leave();
		
		System.out.println("Enter LeaveId   ");
		leave.setLeaveId(sc.nextInt());
		
		System.out.println("Enter EmployId   ");
		leave.setEmpId(sc.nextInt());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("Enter LeaveStartDate (yyyy-MM-dd)  ");
		leave.setLeaveStartDate(sdf.parse(sc.next()));
		
		System.out.println("Enter LeaveEndDate (yyyy-MM-dd)   ");
		leave.setLeaveEndDate(sdf.parse(sc.next()));
		
		System.out.println("Enter Leave Reason   ");
		leave.setLeaveReason(sc.next());
		
		leave.setLeaveAppliedOn(new Date());
		
		System.out.println(new LeaveBAL().addLeaveBal(leave));
	}
	
	public static void showLeave() {
		List<Leave> leaveList= new LeaveBAL().showLeaveBal();
		for (Leave i : leaveList) {
			System.out.println(i);
		}
	}
	
	public static void deleteLeave() {
		System.out.println("Enter Leave No   ");
		int sno =sc.nextInt();
		System.out.println(new LeaveBAL().deleteLeaveBal(sno));
	}
	
	public static void searchLeave() {
		System.out.println("Enter Leave No   ");
		int sno =sc.nextInt();
		Leave Leave = new LeaveBAL().searchLeaveBal(sno);
		if (Leave!=null) {
			System.out.println(Leave);
		} else {
			System.out.println("*** Record Not Found ***");
		}
	}
		
	
	public static void updateLeave() throws LeaveException, ParseException {
		Leave leave = new Leave();
		System.out.println("Enter Leave Id   ");
		leave.setLeaveId(sc.nextInt());

		System.out.println("Enter EmployId   ");
		leave.setEmpId(sc.nextInt());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("Enter LeaveStartDate (yyyy-MM-dd)  ");
		leave.setLeaveStartDate(sdf.parse(sc.next()));
		
		System.out.println("Enter LeaveEndDate (yyyy-MM-dd)   ");
		leave.setLeaveEndDate(sdf.parse(sc.next()));
		
		System.out.println("Enter Leave Reason   ");
		leave.setLeaveReason(sc.next());
		
		leave.setLeaveAppliedOn(new Date());
		
		System.out.println(new LeaveBAL().updateLeaveBal(leave));
	}

	
	
	public static void main(String[] args) {
		int ch;
		do {
			System.out.println("O P T I O N S");
			System.out.println("--------------");
			System.out.println("1. Add Leave");
			System.out.println("2. Show Leaves");
			System.out.println("3. Search Leave");
			System.out.println("4. Delete Leave");
			System.out.println("5. Update Leave");
			System.out.println("6. Exit");
			System.out.println("Enter Your Choice   ");
			ch = sc.nextInt();
			switch(ch) {
			case 1 :
				try {
					addLeave();
				} catch (LeaveException e) {
					System.out.println(e.getMessage());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case 2 : 
				showLeave();
				break;
			case 3 : 
				searchLeave();
				break;
			case 4 :
				deleteLeave();
				break;
			case 5 :
				try {
					updateLeave();
				} catch (LeaveException e) {
					System.out.println(e.getMessage());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case 6 : 
				return;
			}
		} while(ch!=6);
	}
}
