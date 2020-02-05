package com.vijaysankar.hmgsystems.appointment;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointmentlist {
	public int appid;
	public int patientid;
	public String purpose;
	public int doctorid;
	public Date appdate;
	@Override
	public String toString() {
		return "Appointmentlist [appid=" + appid + ", patientid=" + patientid + ", purpose=" + purpose + ", doctorid="
				+ doctorid + ", appdate=" + appdate + ", apptime=" + apptime + ", status=" + status + ", visited="
				+ visited + "]";
	}
	public String apptime;
	public String status;
	public String visited;
	
}
