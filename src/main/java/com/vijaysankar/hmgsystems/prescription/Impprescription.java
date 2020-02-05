package com.vijaysankar.hmgsystems.prescription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.vijaysankar.hmgsystems.patientreg.connections;
import com.vijaysankar.hmgsystems.splzations.Splzationlist;

public class Impprescription {
	public void addData(Prescriptionlist L) throws Exception {
		int fee = 0;
		Connection con = connections.TestConnections();
		Statement stmt = con.createStatement();
		String sql = "insert into prescription(prescription_id,patient_name,doctorname,comments,total_amt)values(prescription_id.nextval,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, L.patientname);
		pst.setString(2, L.doctorname);
		pst.setString(3, L.comments);
		String sql1 = "select consultingfee from doctorlist where doctor_name=?";
		PreparedStatement pst1 = con.prepareStatement(sql1);
		pst1.setString(1, L.doctorname);

		ResultSet rs = pst1.executeQuery();
		if (rs.next()) {
			fee = rs.getInt("consultingfee");
		}
		int total = L.totalamt + fee;
		pst.setInt(4, total);

		int rows = pst.executeUpdate();
		System.out.println("" + rows);

	}

	public ArrayList<Prescriptionlist> viewData() throws Exception {
		ArrayList<Prescriptionlist> p = new ArrayList<Prescriptionlist>();
		Connection con = connections.TestConnections();
		String sql = "select * from prescription ";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Prescriptionlist a = new Prescriptionlist();
			a.presid = rs.getInt("prescription_id");
			a.patientname = rs.getString("patient_name");
			a.doctorname = rs.getString("doctorname");
			a.comments = rs.getString("comments");
			p.add(a);

		}
		return p;
	}

}
