package g1.lmscom.infinite.java.lms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class LeaveDetailsDAO {
	public String addLeave(LeaveDetails leave) throws ClassNotFoundException, SQLException {
		
		Connection connection =ConnectionHelper.getConnection();
		leave.setLeaveType(LeaveType.EL);
	    leave.setLeaveStatus(LeaveStatus.PENDING);
	    leave.setManagerComments("");
	    long diff = leave.getLeaveEndDate().getTime() - leave.getLeaveStartDate().getTime();
		leave.setNoOfDays((int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		
		String cmd = "Insert into leave_history(EMP_ID,LEAVE_START_DATE,LEAVE_END_DATE,LEAVE_REASON,Leave_Type,Leave_Status,LEAVE_MNGR_COMMENTS, LEAVE_NO_OF_DAYS) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst = connection.prepareStatement(cmd);
    	pst.setInt(1, leave.getEmpId());
    	pst.setDate(2, leave.getLeaveStartDate());
    	pst.setDate(3, leave.getLeaveEndDate());
    	pst.setString(5, leave.getLeaveType().toString());
    	pst.setString(6, leave.getLeaveStatus().toString());
    	pst.setString(4, leave.getLeaveReason());
    	pst.setString(7, leave.getManagerComments());
    	pst.setInt(8, leave.getNoOfDays());
    	pst.executeUpdate();
    	
    	return "Leave Added Succesfully...";
	}
	
	public LeaveDetails searchLeave(int Eid)throws ClassNotFoundException, SQLException {

		Connection connection =ConnectionHelper.getConnection();
		String cmd = "select * from leave_history where EMP_ID=?";
		PreparedStatement pst = connection.prepareStatement(cmd);
		pst.setInt(1, Eid);
		ResultSet rs = pst.executeQuery();
		LeaveDetails leave = new LeaveDetails();
		
		if (rs.next()) {
			leave.setEmpId(rs.getInt("EMP_ID"));
			leave.setLeaveId(rs.getInt("LEAVE_ID"));
			leave.setLeaveStartDate(rs.getDate("LEAVE_START_DATE"));
			leave.setLeaveEndDate(rs.getDate("LEAVE_END_DATE"));
			leave.setLeaveReason(rs.getString("LEAVE_REASON"));
			leave.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
			leave.setLeaveType(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
			leave.setManagerComments(rs.getString("LEAVE_MNGR_COMMENTS"));
			leave.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
		}
		return leave;
	}
	
	public void showLeave() throws ClassNotFoundException, SQLException{
		Connection connection =ConnectionHelper.getConnection();
		String cmd = "select * from leave_history";
		PreparedStatement pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		LeaveDetails leave = new LeaveDetails();
		
		while (rs.next()) {
			leave.setEmpId(rs.getInt("EMP_ID"));
			leave.setLeaveId(rs.getInt("LEAVE_ID"));
			leave.setLeaveStartDate(rs.getDate("LEAVE_START_DATE"));
			leave.setLeaveEndDate(rs.getDate("LEAVE_END_DATE"));
			leave.setLeaveReason(rs.getString("LEAVE_REASON"));
			leave.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
			leave.setLeaveType(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
			leave.setManagerComments(rs.getString("LEAVE_MNGR_COMMENTS"));
			leave.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
			
			System.out.println(leave);
		}
	}
	
	public void pendingLeaves() throws ClassNotFoundException, SQLException{
		Connection connection =ConnectionHelper.getConnection();
		String cmd = "select * from leave_history where EMP_ID = 1000 and LEAVE_STATUS = 'PENDING'";
		PreparedStatement pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		LeaveDetails leave = new LeaveDetails();
		
		while (rs.next()) {
			leave.setEmpId(rs.getInt("EMP_ID"));
			leave.setLeaveId(rs.getInt("LEAVE_ID"));
			leave.setLeaveStartDate(rs.getDate("LEAVE_START_DATE"));
			leave.setLeaveEndDate(rs.getDate("LEAVE_END_DATE"));
			leave.setLeaveReason(rs.getString("LEAVE_REASON"));
			leave.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));
			leave.setLeaveType(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
			leave.setManagerComments(rs.getString("LEAVE_MNGR_COMMENTS"));
			leave.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
			
			System.out.println(leave);
		}
	}
}
