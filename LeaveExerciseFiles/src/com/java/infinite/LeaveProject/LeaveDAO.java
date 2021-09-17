package com.java.infinite.LeaveProject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import com.java.infinite.files.Employ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class LeaveDAO {
	
	static List<Leave> lstLeave = new ArrayList<Leave>();
	
	public String addLeaveDao(Leave leave) {
		try {
			FileOutputStream fout = new FileOutputStream("c:/files/leave.txt");
			ObjectOutputStream objout = new ObjectOutputStream(fout);
			lstLeave.add(leave);
			objout.writeObject(lstLeave);
			objout.close();
			fout.close();
			//System.out.println("*** File Copied ***");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//lstLeave.add(Leave);
		return "Leave Record added Successfully...";
	}
	
	public List<Leave> showLeaveDao() {
		return readFile();
	}
	
	public String updateLeaveDao(Leave LeaveNew) {
		Leave LeaveOld = searchLeaveDao(LeaveNew.getLeaveId());
		if (LeaveOld != null) {
			LeaveOld.setEmpId(LeaveNew.getEmpId());
			LeaveOld.setLeaveStartDate(LeaveNew.getLeaveStartDate());
			LeaveOld.setLeaveEndDate(LeaveNew.getLeaveEndDate());
			LeaveOld.setLeaveReason(LeaveNew.getLeaveReason());
			LeaveOld.setNoOfDays((int) TimeUnit.DAYS.convert(LeaveNew.getLeaveEndDate().getTime() - LeaveNew.getLeaveStartDate().getTime(), TimeUnit.MILLISECONDS));
			return "Record Updated Successfully...";
		}
		return "Record Not Found...";
		
	}
	
	public String deleteLeaveDao(int sno) {
		Leave leave = searchLeaveDao(sno);
		if (leave != null) {
			lstLeave.remove(leave);
			return "Record Deleted Successfully...";
		} 
		return "Record Not Found...";
	}
	public Leave searchLeaveDao(int sno) {
		Leave result = null;
		List<Leave> l = showLeaveDao();
		for (Leave Leave : l) {
			if (Leave.getLeaveId() == sno) {
				result=Leave;
				break;
			}
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Leave> readFile() {
		//List<Leave> l = new ArrayList<Leave>();
		try {
			FileInputStream fin = new FileInputStream("c:/files/leave.txt");
			ObjectInputStream objin = new ObjectInputStream(fin);
			lstLeave = (List<Leave>)objin.readObject();
			/*boolean cont = true;
			while(cont) {
				if(fin.available() != 0) {
					Leave leave = (Leave)objin.readObject();
					l.add(leave);
					} else {
						cont = false;
					}
					//objin.close();
				//objin.reset();
			}*/
			
			
			//System.out.println(leave);
			objin.close();
			fin.close();
			
			//System.out.println(leave);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return leave;
		return lstLeave;
	}
}
