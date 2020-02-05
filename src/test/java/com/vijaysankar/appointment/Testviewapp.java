package com.vijaysankar.appointment;

import java.util.ArrayList;

import com.vijaysankar.hmgsystems.appointment.Appointmentlist;
import com.vijaysankar.hmgsystems.appointment.Impappointment;

public class Testviewapp {

	public static void main(String[] args) throws Exception {
		
		Impappointment x=new Impappointment();
		ArrayList<Appointmentlist> obj=new ArrayList<Appointmentlist>();
		obj=x.viewapp();
		for (Appointmentlist pa: obj) {
			System.out.println(pa);
		}
		

		
		
		

	}

}
