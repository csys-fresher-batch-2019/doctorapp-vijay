package com.vijaysankar.hmgsystems.overallrating;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;
import com.vijaysankar.hmgsystems.patientreg.connections;
import com.vijaysankar.hmgsystems.util.Logger;

public class Impoverall {
		
	Logger logger=Logger.getInstance();

	public void syncrating(int doctorid) throws Exception{
		
		String sql1="select avg(rating) as avg from rating where doctor_id="+doctorid;
		try(Connection con = connections.TestConnections();
		Statement stmt=con.createStatement();)
		{
		try(ResultSet rs= stmt.executeQuery(sql1);)
		{
		rs.next();
		float average=rs.getFloat("avg");
		System.out.println(average);
		String sql = "update overallrating set rating =? where doctor_id=?";
		PreparedStatement pst= con.prepareStatement(sql);	
		pst.setFloat(1,average);
		pst.setInt(2,doctorid);
		int row=pst.executeUpdate();
		logger.info(row);
		}
		}
		catch(Dbexception e){
			throw new Dbexception("Updation of doctor_id in overallrating failed");
		}
		}
	
	public void add(Overallrating o) throws Exception{
		
		String sql="insert into overallrating(doctor_id) values(?)";
		try(Connection con=connections.TestConnections();
		PreparedStatement pst=con.prepareStatement(sql);)
		{
		pst.setInt(1, o.doctor_id);
		int row = pst.executeUpdate();
		logger.info(row);
		}
		catch(Dbexception e) {
			throw new Dbexception("inserting doctor_id in overallrating failed");
		}
		}
	
	public ArrayList<Overallrating> viewrating() throws Exception{
		String sql = "select * from overallrating ";
		ArrayList<Overallrating> obj=new ArrayList<Overallrating>();
		try(Connection con = connections.TestConnections();
		Statement stmt = con.createStatement();)
		{
		try(ResultSet rs = stmt.executeQuery(sql);)
		{
		while (rs.next()) {
			Overallrating o = new Overallrating();
			o.doctor_id = rs.getInt("doctor_id");
			o.rating = rs.getInt("rating");
			obj.add(o);
		}
		return obj;
		}
		}
		catch(Dbexception e) {
			throw new Dbexception("selection of overallrating failed");
		}
		}
		}

