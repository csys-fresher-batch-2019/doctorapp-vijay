package com.vijaysankar.hmgsystems.doctors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;
import com.vijaysankar.hmgsystems.patientreg.connections;
import com.vijaysankar.hmgsystems.util.Logger;

public class Impdoctor {	
	Logger logger=Logger.getInstance();

	public void adddoctor(Doctorlist d) throws Dbexception{
		String sql = "insert into doctorlist values(?,?,?,?)";
		try(Connection con = connections.TestConnections();
		PreparedStatement pst= con.prepareStatement(sql);)
		{	
		pst.setInt(1,d.getDoctorid());	
		pst.setString(2,d.getDoctorname());
		pst.setInt(3,d.getSplzationid());
		pst.setInt(4,d.getConsultingfee());
		int rows = pst.executeUpdate();
		logger.info(rows);
		}
		catch(Exception e) {
		throw new Dbexception("insertion doctorlist failed");	
		}
		}

	public ArrayList<Doctorlist> viewdoctor() throws Dbexception{
		String sql = "select * from doctorlist";
		ArrayList<Doctorlist> s1= new ArrayList<Doctorlist>();
		try(Connection con = connections.TestConnections();	
		Statement stmt=con.createStatement();)
		{
		try(ResultSet rs=stmt.executeQuery(sql);)
		{
		while(rs.next()) {
			Doctorlist p2= new Doctorlist();
			p2.setDoctorid(rs.getInt("doctor_id"));
			p2.setDoctorname(rs.getString("doctor_name"));
			p2.setSplzationid(rs.getInt("splzation_id"));
			p2.setConsultingfee(rs.getInt("consultingfee"));
			s1.add(p2);
		}
		}
		return s1;
		}catch(Exception e) {
		throw new Dbexception("selection doctorlist failed");	
		}
		}
		}
