package com.vijaysankar.appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import com.vijaysankar.hmgsystems.appointment.Appointmentlist;
import com.vijaysankar.hmgsystems.appointment.Impappointment;


public class Testappointmentlist {
	public static void main(String[] args) throws Exception {

		Appointmentlist m= new Appointmentlist();
		Impappointment p=new Impappointment();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Appointment details \n");
		System.out.println("Enter Patientid ");
		m.patientid=sc.nextInt();
		System.out.println("Enter Purpose ");
		m.purpose=sc.next();
		System.out.println("Enter Doctorid ");
		m.doctorid=sc.nextInt();
		System.out.println("Enter Appointment date ");
		String a=sc.next();
		LocalDate sr=LocalDate.parse(a);
		m.appdate=java.sql.Date.valueOf(sr);
		System.out.println("Enter Appointment Time "); 
		m.apptime=sc.next();
		p.addappointment(m);
		
		
	}

}
