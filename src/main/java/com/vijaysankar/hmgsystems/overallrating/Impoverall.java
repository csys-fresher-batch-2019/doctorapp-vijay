package com.vijaysankar.hmgsystems.overallrating;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.vijaysankar.hmgsystems.patientreg.connections;
import com.vijaysankar.hmgsystems.prescription.Prescriptionlist;

public class Impoverall {
	
	public void syncrating(int doctorid) throws Exception{
		
		Connection con = connections.TestConnections();
		Statement stmt=con.createStatement();
		String sql1="select avg(rating) as avg from rating where doctor_id="+doctorid;
		ResultSet rs= stmt.executeQuery(sql1);
		rs.next();
		float average=rs.getFloat("avg");
		System.out.println(average);
		String sql = "update overallrating set rating =? where doctor_id=?";
		PreparedStatement pst= con.prepareStatement(sql);	
		pst.setFloat(1,average);
		pst.setInt(2,doctorid);
		int row=pst.executeUpdate();
		System.out.println(row);
	}
	
	public void add(Overallrating o) throws Exception{
		
		Connection con=connections.TestConnections();
		String sql="insert into overallrating(doctor_id) values(?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, o.doctor_id);
		int row = pst.executeUpdate();
		System.out.println(row);
	}
	
	public ArrayList<Overallrating> viewrating() throws Exception{
		
		ArrayList<Overallrating> obj=new ArrayList<Overallrating>();
		
		Connection con = connections.TestConnections();
		String sql = "select * from overallrating ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Overallrating o = new Overallrating();
			o.doctor_id = rs.getInt("doctor_id");
			o.rating = rs.getInt("rating");
			obj.add(o);

		}
		return obj;
	
	
	
	
	
	}
}
