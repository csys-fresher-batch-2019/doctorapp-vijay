package com.vijaysankar.hmgsystems.userrating;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.vijaysankar.hmgsystems.overallrating.Impoverall;
import com.vijaysankar.hmgsystems.overallrating.Overallrating;
import com.vijaysankar.hmgsystems.patientreg.connections;

public class Impuserrating {
	
	public void addrating(Userrating u) throws Exception{
		
		Connection con = connections.TestConnections();
		String sql = "insert into rating values(?,?,?)";
		PreparedStatement pst= con.prepareStatement(sql);	
		pst.setInt(1,u.patient_id);	
		pst.setInt(2,u.doctor_id);
		pst.setFloat(3,u.rating);
		int row= pst.executeUpdate();
		System.out.println(""+row);
		Impoverall obj=new Impoverall();
		obj.syncrating(u.doctor_id);
		
	}

}
