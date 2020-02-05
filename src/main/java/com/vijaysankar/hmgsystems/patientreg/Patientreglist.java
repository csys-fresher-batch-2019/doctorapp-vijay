package com.vijaysankar.hmgsystems.patientreg;

import java.sql.Date;
import java.time.LocalDate;

public class Patientreglist {
	public int patientId;
	public String patientname;
	public long adharno;
	public LocalDate dob; 
	public String gender;
	public long phoneno;
	public Date regdate;
	public String toString() {
		return "Patientreglist [patientId=" + patientId + ", patientname=" + patientname + ", adharno=" + adharno
				+ ", dob=" + dob + ", gender=" + gender + ", phoneno=" + phoneno + ", regDate=" + regdate + "]";
	}
	

}
