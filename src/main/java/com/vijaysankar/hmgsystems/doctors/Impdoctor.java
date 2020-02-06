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

	public void adddoctor(Doctorlist d) throws Exception{
		String sql = "insert into doctorlist values(?,?,?,?)";
		try(Connection con = connections.TestConnections();
		PreparedStatement pst= con.prepareStatement(sql);)
		{	
		pst.setInt(1,d.doctorid);	
		pst.setString(2,d.doctorname);
		pst.setInt(3,d.splzationid);
		pst.setInt(4,d.consultingfee);
		int rows = pst.executeUpdate();
		logger.info(rows);
		}
		catch(Dbexception e) {
		throw new Dbexception("insertion doctorlist failed");	
		}
		}

	public ArrayList<Doctorlist> viewdoctor() throws Exception{
		String sql = "select * from doctorlist";
		ArrayList<Doctorlist> s1= new ArrayList<Doctorlist>();
		try(Connection con = connections.TestConnections();	
		Statement stmt=con.createStatement();)
		{
		try(ResultSet rs=stmt.executeQuery(sql);)
		{
		while(rs.next()) {
			Doctorlist p2= new Doctorlist();
			p2.doctorid=rs.getInt("doctor_id");
			p2.doctorname=rs.getString("doctor_name");
			p2.splzationid=rs.getInt("splzation_id");
			p2.consultingfee=rs.getInt("consultingfee");
			s1.add(p2);
		}
		}
		return s1;
		}catch(Dbexception e) {
		throw new Dbexception("selection doctorlist failed");	
		}
		}
		}
