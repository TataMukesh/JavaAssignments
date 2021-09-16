package com.java.infinite.bank;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateAccountMain {
	
	public static void main(String[] args) {
		BankDAO dao = new BankDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter AccountNo   ");
		int accno = sc.nextInt();
		System.out.println("Enter FirstName   ");
		String Fname = sc.next();
		System.out.println("Enter LastName  ");
		String Lname = sc.next();
		System.out.println("Enter City  ");
		String city = sc.next();
		System.out.println("Enter State  ");
		String state = sc.next();
		try {
			System.out.println(dao.updateAccount(accno, Fname, Lname, city, state));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
