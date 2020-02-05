package com.vijaysankar.hmgsystems.doctors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.vijaysankar.hmgsystems.patientreg.connections;

public class Impdoctor {
	public void adddoctor(Doctorlist d) throws Exception{
		Connection con = connections.TestConnections();
		String sql = "insert into doctorlist values(?,?,?,?)";
		PreparedStatement pst= con.prepareStatement(sql);	
		pst.setInt(1,d.doctorid);	
		pst.setString(2,d.doctorname);
		pst.setInt(3,d.splzationid);
		pst.setInt(4,d.consultingfee);
		int rows = pst.executeUpdate();
		System.out.println(""+rows);
	}

	public ArrayList<Doctorlist> viewdoctor() throws Exception{
		ArrayList<Doctorlist> s1= new ArrayList<Doctorlist>();
		Connection con = connections.TestConnections();	
		String sql = "select * from doctorlist";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			Doctorlist p2= new Doctorlist();
			p2.doctorid=rs.getInt("doctor_id");
			p2.doctorname=rs.getString("doctor_name");
			p2.splzationid=rs.getInt("splzation_id");
			p2.consultingfee=rs.getInt("consultingfee");
			s1.add(p2);



}
		return s1;
	}
}
