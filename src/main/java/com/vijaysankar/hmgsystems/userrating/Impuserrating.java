package com.vijaysankar.hmgsystems.userrating;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;
import com.vijaysankar.hmgsystems.overallrating.Impoverall;
import com.vijaysankar.hmgsystems.patientreg.connections;

public class Impuserrating {
	
	public void addrating(Userrating u) throws Dbexception{
	
		String sql = "insert into rating values(?,?,?)";
		try(Connection con = connections.TestConnections();
		PreparedStatement pst= con.prepareStatement(sql);)
		{
		pst.setInt(1,u.getPatient_id());	
		pst.setInt(2,u.getDoctor_id());
		pst.setFloat(3,u.getRating());
		int row= pst.executeUpdate();
		System.out.println(""+row);
		Impoverall obj=new Impoverall();
		obj.syncrating(u.getDoctor_id());
		}catch(Exception e) {
			throw new Dbexception("Insertion into Rating failed");
		}
		}
		}	
