package com.vijaysankar.hmgsystems.appointment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;
import com.vijaysankar.hmgsystems.patientreg.connections;
import com.vijaysankar.hmgsystems.util.Logger;

public class Impappointment {
	Logger logger=Logger.getInstance();
	
	public void addappointment(Appointmentlist a) throws Dbexception{
		
		
		String sql = "insert into appointment (app_id,patient_id,purpose,doctor_id,app_date,app_time) values(?,?,?,?,?,?)";      
		try(Connection con = connections.TestConnections();
		PreparedStatement pst= con.prepareStatement(sql);)
		{
		pst.setInt(1,a.getAppid());
		pst.setInt(2,a.getPatientid());	
		pst.setString(3,a.getPurpose());
		pst.setInt(4,a.getDoctorid());
		pst.setDate(5,Date.valueOf(a.getAppdate()));		
		pst.setString(6, a.getApptime());
		int rows = pst.executeUpdate();
		logger.info(rows);
		}
		catch(Exception e){
			throw new Dbexception("Appointment insertion failed");
	}
	}
	
	public void updateappointment(Appointmentlist b) throws Dbexception{
		String sql= "update appointment set status='approved' where app_id= ?";
		try(Connection con = connections.TestConnections();
		PreparedStatement pst= con.prepareStatement(sql);)	
		{
		pst.setInt(1,b.getAppid());	
		int rows = pst.executeUpdate();
		logger.info(rows);
		}
		catch(Exception e) {
			throw new Dbexception("Appointment approve status failed");
		}
		}
public void updatevisited(Appointmentlist c) throws Dbexception{
		
		String sql1= "update appointment set visited = 'yes' where app_id=?";
		try(Connection con = connections.TestConnections();
		PreparedStatement pst= con.prepareStatement(sql1);)
		{
		pst.setInt(1,c.getAppid());	
		int rows = pst.executeUpdate();
		logger.info(rows);
		}
		catch(Exception e) {
			throw new Dbexception("Appointment visited status failed");
		}
		}
public ArrayList<Appointmentlist> viewapp() throws Dbexception{
	
	String sql = "select * from appointment ";
	ArrayList<Appointmentlist> obj=new ArrayList<Appointmentlist>();
	try(Connection con = connections.TestConnections();	
	Statement stmt=con.createStatement();){
		try(ResultSet rs=stmt.executeQuery(sql);)
		{
	while(rs.next()) 
		{
		Appointmentlist h= new Appointmentlist();
		h.setAppid(rs.getInt("app_id"));
		h.setPatientid(rs.getInt("patient_id"));
		h.setPurpose(rs.getString("purpose"));
		h.setDoctorid(rs.getInt("doctor_id"));
		Date st=rs.getDate("app_date");
		h.setAppdate(st.toLocalDate());
		h.setApptime(rs.getString("app_time"));
		h.setStatus(rs.getString("status"));
		h.setVisited(rs.getString("visited"));
		obj.add(h);
		}
		}
	return obj;
	}catch(Exception e) {
		throw new Dbexception("selection failed");
	}
	}
	}




