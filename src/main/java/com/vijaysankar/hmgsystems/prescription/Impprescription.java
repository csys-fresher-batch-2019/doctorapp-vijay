package com.vijaysankar.hmgsystems.prescription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;
import com.vijaysankar.hmgsystems.patientreg.connections;
import com.vijaysankar.hmgsystems.util.Logger;

public class Impprescription {
		
	Logger logger=Logger.getInstance();

	public void addData(Prescriptionlist L) throws Dbexception {
		int fee = 0;
		String sql = "insert into prescription(prescription_id,patient_name,doctorname,comments,total_amt)values(prescription_id.nextval,?,?,?,?)";

		try(Connection con = connections.TestConnections();
		PreparedStatement pst = con.prepareStatement(sql);)
		{
		pst.setString(1, L.getPatientname());
		pst.setString(2, L.getDoctorname());
		pst.setString(3, L.getComments());
		String sql1 = "select consultingfee from doctorlist where doctor_name=?";
		try(PreparedStatement pst1 = con.prepareStatement(sql1);)
		{
		pst1.setString(1, L.getDoctorname());
		try(ResultSet rs = pst1.executeQuery();)
		{
		if (rs.next()) {
			fee = rs.getInt("consultingfee");
		}
		int total = L.getTotalamt() + fee;
		pst.setInt(4, total);
		int rows = pst.executeUpdate();
		logger.info(rows);
		}
		}
		}catch(Exception e) {
			throw new Dbexception("inserting values into prescription failed");
		}	
	}
	public ArrayList<Prescriptionlist> viewData() throws Dbexception {
		
		String sql = "select * from prescription ";
		ArrayList<Prescriptionlist> p = new ArrayList<Prescriptionlist>();
		try(Connection con = connections.TestConnections();
		Statement stmt = con.createStatement();)
		{
		try(ResultSet rs = stmt.executeQuery(sql);)
		{
		while (rs.next()) {
			Prescriptionlist a = new Prescriptionlist();
			a.setPresid(rs.getInt("prescription_id"));
			a.setPatientname(rs.getString("patient_name"));
			a.setDoctorname(rs.getString("doctorname"));
			a.setComments(rs.getString("comments"));
			a.setTotalamt(rs.getInt("total_amt"));
			p.add(a);
		}
		return p;
		}
		}catch(Exception e) {
		throw new Dbexception("selection from prescription failed");
		}
		}
		}
