package com.vijaysankar.hmgsystems;

import java.util.ArrayList;

import com.vijaysankar.hmgsystems.patientreg.ImpPatients;
import com.vijaysankar.hmgsystems.patientreg.Patientreglist;

public class TestviewReg {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ImpPatients obj = new ImpPatients();
		ArrayList<Patientreglist> patient = new ArrayList<Patientreglist>();			
		patient=obj.viewpatient();
		for (Patientreglist patientlist: patient) {
			System.out.println(patientlist);
		}

	}

}
