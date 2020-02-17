package com.vijaysankar.appointment;

import java.util.Scanner;

import com.vijaysankar.hmgsystems.appointment.Appointmentlist;
import com.vijaysankar.hmgsystems.appointment.Impappointment;

public class Testupdatevisited {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Impappointment impapp= new Impappointment();
		Appointmentlist appli= new Appointmentlist();
		System.out.println("Enter Patient's Appointment Id:");
		Scanner sc= new Scanner(System.in);
		appli.setAppid(sc.nextInt());
		int aid = appli.getAppid();
		impapp.updatevisited(aid);
		sc.close();
		

	}

}
