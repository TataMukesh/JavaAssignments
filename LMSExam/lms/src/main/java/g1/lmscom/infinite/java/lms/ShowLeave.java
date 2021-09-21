package g1.lmscom.infinite.java.lms;

import java.sql.SQLException;

public class ShowLeave {
	public static void main(String[] args) {
		try {
			new LeaveDetailsDAO().showLeave();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
