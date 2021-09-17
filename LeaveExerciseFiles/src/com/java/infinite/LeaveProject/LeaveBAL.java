package com.java.infinite.LeaveProject;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LeaveBAL {
	
	static StringBuilder sb = new StringBuilder();
	
	public boolean validateLeave(Leave leave) {
		boolean isAdded=true;
		if (leave.getLeaveStartDate().compareTo(new Date()) < 0) {
			isAdded=false;
			sb.append("leaveStartDate cannot be yesterdays date\r\n");
		}
		
		if (leave.getLeaveEndDate().compareTo(new Date()) < 0) {
			isAdded=false;
			sb.append("leaveEndDate cannot be yesterdays date\r\n");
		}
		
		if (leave.getLeaveEndDate().compareTo(leave.getLeaveStartDate()) < 0) {
			isAdded=false;
			sb.append("leaveStartDate must be less than or equals to leaveEndDate\r\n");
		}
		
		if(isAdded) {
			long diff = leave.getLeaveEndDate().getTime() - leave.getLeaveStartDate().getTime();
			leave.setNoOfDays((int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		}
		
		return isAdded;
	}
	
	public List<Leave> showLeaveBal() {
		return new LeaveDAO().showLeaveDao();
	}
	
	public String addLeaveBal(Leave leave) throws LeaveException {
		if (validateLeave(leave) == true) {
			return new LeaveDAO().addLeaveDao(leave);
		} else {
			throw new LeaveException(sb.toString());
		}
	}
	
	public Leave searchLeaveBal(int sno) {
		return new LeaveDAO().searchLeaveDao(sno);
	}
	
	public String updateLeaveBal(Leave leave) throws LeaveException {
		if (validateLeave(leave) == true) {
			return new LeaveDAO().updateLeaveDao(leave);
		} else {
			throw new LeaveException(sb.toString());
		}
	}
	
	public String deleteLeaveBal(int sno) {
		return new LeaveDAO().deleteLeaveDao(sno);
	}
	
}
