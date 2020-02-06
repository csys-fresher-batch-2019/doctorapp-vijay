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

	public void addData(Prescriptionlist L) throws Exception {
		int fee = 0;
		String sql = "insert into prescription(prescription_id,patient_name,doctorname,comments,total_amt)values(prescription_id.nextval,?,?,?,?)";

		try(Connection con = connections.TestConnections();
		PreparedStatement pst = con.prepareStatement(sql);)
		{
		pst.setString(1, L.patientname);
		pst.setString(2, L.doctorname);
		pst.setString(3, L.comments);
		String sql1 = "select consultingfee from doctorlist where doctor_name=?";
		try(PreparedStatement pst1 = con.prepareStatement(sql1);)
		{
		pst1.setString(1, L.doctorname);
		try(ResultSet rs = pst1.executeQuery();)
		{
		if (rs.next()) {
			fee = rs.getInt("consultingfee");
		}
		int total = L.totalamt + fee;
		pst.setInt(4, total);
		int rows = pst.executeUpdate();
		logger.info(rows);
		}
		}
		}catch(Dbexception e) {
			throw new Dbexception("inserting values into prescription failed");
		}	
	}
	public ArrayList<Prescriptionlist> viewData() throws Exception {
		
		String sql = "select * from prescription ";
		ArrayList<Prescriptionlist> p = new ArrayList<Prescriptionlist>();
		try(Connection con = connections.TestConnections();
		Statement stmt = con.createStatement();)
		{
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Prescriptionlist a = new Prescriptionlist();
			a.presid = rs.getInt("prescription_id");
			a.patientname = rs.getString("patient_name");
			a.doctorname = rs.getString("doctorname");
			a.comments = rs.getString("comments");
			a.totalamt=rs.getInt("total_amt");
			p.add(a);
		}
		return p;
		}catch(Dbexception e) {
		throw new Dbexception("selection from prescription failed");
		}
		}
		}
