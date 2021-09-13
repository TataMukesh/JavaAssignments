package com.java.infinite.LeaveProject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LeaveDAO {
	
	static List<Leave> lstLeave = new ArrayList<Leave>();
	
	public String addLeaveDao(Leave Leave) {
		lstLeave.add(Leave);
		return "Leave Record added Successfully...";
	}
	
	public List<Leave> showLeaveDao() {
		return lstLeave;
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
		for (Leave Leave : lstLeave) {
			if (Leave.getLeaveId() == sno) {
				result=Leave;
				break;
			}
		}
		return result;
	}
	
}
