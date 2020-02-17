package com.vijaysankar.hmgsystems.appointment;

import java.util.ArrayList;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;

public interface Interfaceapp {
	public void addappointment(Appointmentlist a) throws Dbexception;
	public void updateappointment(int pid) throws Dbexception;
	public void updatevisited(int aid) throws Dbexception;
	public ArrayList<Appointmentlist> viewapp() throws Dbexception;
}
