package com.vijaysankar.appointment;

import java.util.Scanner;

import com.vijaysankar.hmgsystems.appointment.Appointmentlist;
import com.vijaysankar.hmgsystems.appointment.Impappointment;

public class Testupdatevisited {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Impappointment a= new Impappointment();
		Appointmentlist b= new Appointmentlist();
		System.out.println("Enter Patient Id:");
		Scanner sc= new Scanner(System.in);
		b.patientid=sc.nextInt();
		a.updatevisited(b);
		
		

	}

}
