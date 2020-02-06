package com.vijaysankar.appointment;

import java.util.Scanner;

import com.vijaysankar.hmgsystems.appointment.Appointmentlist;
import com.vijaysankar.hmgsystems.appointment.Impappointment;

public class Testupdateappointment {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Impappointment i=new Impappointment();
		Appointmentlist a=new Appointmentlist();
		Scanner sc=new Scanner(System.in);
		System.out.println("Update patient status \n");
		System.out.println("Enter patient Appointment ID");
		a.appid=sc.nextInt();
		i.updateappointment(a);
		sc.close();
	}

}
