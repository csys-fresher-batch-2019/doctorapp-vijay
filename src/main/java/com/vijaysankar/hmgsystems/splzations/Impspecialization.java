package com.vijaysankar.hmgsystems.splzations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.vijaysankar.hmgsystems.patientreg.connections;

public class Impspecialization {

	public void addspecialization(Splzationlist sp) throws Exception {

		Connection con = connections.TestConnections();
		String sql = "insert into splzations values(?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, sp.splzationid);
		pst.setString(2, sp.Splzationname);
		int rows = pst.executeUpdate();
		System.out.println("" + rows);

	}

	public ArrayList<Splzationlist> viewspl() throws Exception {
		ArrayList<Splzationlist> s1 = new ArrayList<Splzationlist>();
		Connection con = connections.TestConnections();
		String sql = "select * from splzations";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Splzationlist p2 = new Splzationlist();
			p2.splzationid = rs.getInt("splzation_id");
			p2.Splzationname = rs.getString("splzation_name");
			s1.add(p2);

		}
		return s1;
	}
}
