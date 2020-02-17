package com.vijaysankar.appointment;

import java.util.Scanner;

import com.vijaysankar.hmgsystems.appointment.Appointmentlist;
import com.vijaysankar.hmgsystems.appointment.Impappointment;

public class Testupdateappointment {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Impappointment impapp=new Impappointment();
		Appointmentlist appli=new Appointmentlist();
		Scanner sc=new Scanner(System.in);
		System.out.println("Update patient status \n");
		System.out.println("Enter patient's Appointment ID");
		appli.setAppid(sc.nextInt());
		int pid = appli.getAppid();
		impapp.updateappointment(pid);
		sc.close();
	}

}
