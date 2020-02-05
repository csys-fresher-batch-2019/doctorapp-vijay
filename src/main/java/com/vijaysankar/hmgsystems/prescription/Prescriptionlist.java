package com.vijaysankar.hmgsystems.prescription;

public class Prescriptionlist {
	public int presid;
	public String patientname;
	public String doctorname;
	public String comments;
	public int totalamt;
	@Override
	public String toString() {
		return "Prescriptionlist [presid=" + presid + ", patientname=" + patientname + ", doctorname=" + doctorname
				+ ", comments=" + comments + ", totalamt=" + totalamt + "]";
	}
	
}
