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

	Logger logger = Logger.getInstance();

	public void syncrating(int doctorid) throws Dbexception {
		String sql1 = "select avg(rating) as avg from rating where doctor_id=?";
		try (Connection con = connections.TestConnections();
			PreparedStatement pst = con.prepareStatement(sql1);)
		{
			pst.setInt(1, doctorid);
			try (ResultSet rs = pst.executeQuery();) 
			{
				rs.next();
				float average = rs.getFloat("avg");
				System.out.println(average);
				String sql = "update overallrating set rating =? where doctor_id=?";
				try (PreparedStatement pst1 = con.prepareStatement(sql);) {
					pst1.setFloat(1, average);
					pst1.setInt(2, doctorid);
					int row = pst1.executeUpdate();
					logger.info(row);
				}
			}
		} catch (Exception e) {
			throw new Dbexception("Updation of doctor_id in overallrating failed");
		}
	}

	public void add(int doc) throws Dbexception {

		String sql = "insert into overallrating(doctor_id) values(?)";
		try (Connection con = connections.TestConnections(); 
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, doc);
			int row = pst.executeUpdate();
			logger.info(row);
		} catch (Exception e) {
			throw new Dbexception("inserting doctor_id in overallrating failed");
		}
	}

	public ArrayList<Overallrating> viewrating() throws Dbexception {
		String sql = "select * from overallrating ";
		ArrayList<Overallrating> obj = new ArrayList<Overallrating>();
		try (Connection con = connections.TestConnections();
				Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					Overallrating o = new Overallrating();
					o.setDoctor_id(rs.getInt("doctor_id"));
					o.setRating(rs.getInt("rating"));
					obj.add(o);
				}
				return obj;
			}
		} catch (Exception e) {
			throw new Dbexception("selection of overallrating failed");
		}
	}
}
