package com.vijaysankar.hmgsystems.appointment;

import java.util.ArrayList;

import com.vijaysankar.hmgsystems.doctors.Doctorlist;

public interface Interfaceapp {
	public void addappointment(Appointmentlist a) throws Exception;
	public void updateappointment(Appointmentlist b) throws Exception;
	public void updatevisited(Appointmentlist c) throws Exception;
	public ArrayList<Appointmentlist> viewapp() throws Exception;
}
