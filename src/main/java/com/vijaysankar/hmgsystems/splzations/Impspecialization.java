package com.vijaysankar.hmgsystems.splzations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;
import com.vijaysankar.hmgsystems.patientreg.connections;
import com.vijaysankar.hmgsystems.util.Logger;

public class Impspecialization {
	
	Logger logger=Logger.getInstance();

	public void addspecialization(Splzationlist sp) throws Dbexception {
		
		String sql = "insert into splzations values(?,?)";
		try(Connection con = connections.TestConnections();
		PreparedStatement pst = con.prepareStatement(sql);)
		{
		pst.setInt(1, sp.getSplzationid());
		pst.setString(2, sp.getSplzationname());
		int rows = pst.executeUpdate();
		logger.info(rows);
		}
		
		catch(Exception e) {
			throw new Dbexception("Insertion into specialization failed");
		}
		}
	
	public ArrayList<Splzationlist> viewspl() throws Dbexception {
		
		String sql = "select * from splzations";
		ArrayList<Splzationlist> s1 = new ArrayList<Splzationlist>();
		try(Connection con = connections.TestConnections();
		Statement stmt = con.createStatement();)
		{
		try(ResultSet rs = stmt.executeQuery(sql);)
		{
		while (rs.next()) {
			Splzationlist p2 = new Splzationlist();
			p2.setSplzationid(rs.getInt("splzation_id"));
			p2.setSplzationname(rs.getString("splzation_name"));
			s1.add(p2);
		}
		}
		return s1;
		}catch(Exception e) {
			throw new Dbexception("selection from specializations failed");
		}
		}
		}
		
