package com.vijaysankar.hmgsystems.appointment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.vijaysankar.hmgsystems.patientreg.Patientreglist;
import com.vijaysankar.hmgsystems.patientreg.connections;

public class Impappointment {
	
	public void addappointment(Appointmentlist a) throws Exception{
		
		Connection con = connections.TestConnections();
		String sql = "insert into appointment (app_id,patient_id,purpose,doctor_id,app_date,app_time) values(app_id.nextval,?,?,?,?,?)";      
		PreparedStatement pst= con.prepareStatement(sql);	
		pst.setInt(1,a.patientid);	
		pst.setString(2,a.purpose);
		pst.setInt(3,a.doctorid);
		pst.setDate(4,a.appdate);		
		pst.setString(5, a.apptime);
		
		int rows = pst.executeUpdate();
		System.out.println(""+rows);
	
	}
	
	public void updateappointment(Appointmentlist b) throws Exception{
		
		Connection con = connections.TestConnections();
		String sql= "update appointment set status='approved' where patient_id= ?";
		PreparedStatement pst= con.prepareStatement(sql);	
		pst.setInt(1,b.patientid);	
		int rows = pst.executeUpdate();
		
		System.out.println(""+rows);
		
	}
public void updatevisited(Appointmentlist c) throws Exception{
		
		Connection con = connections.TestConnections();
		String sql1= "update appointment set visited = 'yes' where patient_id=?";
		PreparedStatement pst= con.prepareStatement(sql1);	
		pst.setInt(1,c.patientid);	
		int rows = pst.executeUpdate();
		
		System.out.println(""+rows);
		
	}

public ArrayList<Appointmentlist> viewapp() throws Exception{
	ArrayList<Appointmentlist> obj=new ArrayList<Appointmentlist>();
	Connection con = connections.TestConnections();	
	String sql = "select * from appointment ";
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	while(rs.next()) {
		Appointmentlist h= new Appointmentlist();
		h.appid=rs.getInt("app_id");
		h.patientid=rs.getInt("patient_id");
		h.purpose=rs.getString("purpose");
		h.doctorid=rs.getInt("doctor_id");
		h.appdate=rs.getDate("app_date");
		h.apptime=rs.getString("app_time");
		h.status=rs.getString("status");
		h.visited=rs.getString("visited");
		obj.add(h);

	
}
	return obj;
	}
}



