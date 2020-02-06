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

	public void addspecialization(Splzationlist sp) throws Exception {
		
		String sql = "insert into splzations values(?,?)";
		try(Connection con = connections.TestConnections();)
		{
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, sp.splzationid);
		pst.setString(2, sp.Splzationname);
		int rows = pst.executeUpdate();
		logger.info(rows);
		}
		catch(Dbexception e) {
			throw new Dbexception("Insertion into specialization failed");
		}
		}
	
	public ArrayList<Splzationlist> viewspl() throws Exception {
		
		String sql = "select * from splzations";
		ArrayList<Splzationlist> s1 = new ArrayList<Splzationlist>();
		try(Connection con = connections.TestConnections();
		Statement stmt = con.createStatement();)
		{
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Splzationlist p2 = new Splzationlist();
			p2.splzationid = rs.getInt("splzation_id");
			p2.Splzationname = rs.getString("splzation_name");
			s1.add(p2);
		}
		return s1;
		}catch(Dbexception e) {
			throw new Dbexception("selection from specializations failed");
		}
		}
		}
