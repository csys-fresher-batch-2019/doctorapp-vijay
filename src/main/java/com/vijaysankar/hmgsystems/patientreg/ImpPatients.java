package com.vijaysankar.hmgsystems.patientreg;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;
import com.vijaysankar.hmgsystems.util.Logger;
public class ImpPatients {
		
	Logger logger=Logger.getInstance();

	public void addpatient(Patientreglist p1) throws Exception{
		String sql = "insert into patientReg(patient_id,patientname,adharcardno,dob,gender,phoneno,patientreg_date)values(patient_id.nextval,?,?,?,?,?,sysdate)";
		try(Connection con = connections.TestConnections();
		PreparedStatement pst= con.prepareStatement(sql);)
		{
		pst.setString(1,p1.patientname);	
		pst.setLong(2,p1.adharno );
		java.sql.Date dat = java.sql.Date.valueOf(p1.dob);
		pst.setDate(3,dat);
		pst.setString(4,p1.gender );	
		pst.setLong(5,p1.phoneno );
		int rows= pst.executeUpdate();
		logger.info(rows);
	}catch(Dbexception e) {
		throw new Dbexception("Insertion into patient Registration failed");
	}
	}
	public ArrayList<Patientreglist> viewpatient() throws Exception{
		String sql = "select * from patientReg";
		ArrayList<Patientreglist> obj=new ArrayList<Patientreglist>();
		try(Connection con = connections.TestConnections();	
		Statement stmt=con.createStatement();)
		{
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			Patientreglist p2= new Patientreglist();
			p2.patientId=rs.getInt("patient_id");
			p2.patientname=rs.getString("patientname");
			p2.adharno=rs.getLong("adharcardno");
			Date st=rs.getDate("dob");
			if (st != null) {
			p2.dob=st.toLocalDate();
			}
			p2.gender=rs.getString("gender");
			p2.phoneno=rs.getLong("phoneno");
			p2.regdate=rs.getDate("patientReg_date");
			obj.add(p2);	
			}
		return obj;	
		}catch(Dbexception e) {
			throw new Dbexception("Selection from patient Registration failed");
		}
		}
		}