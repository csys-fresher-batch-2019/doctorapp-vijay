package com.vijaysankar.appointment;

import java.time.LocalDate;
import java.util.Scanner;

import com.vijaysankar.hmgsystems.appointment.Appointmentlist;
import com.vijaysankar.hmgsystems.appointment.Impappointment;
import com.vijaysankar.hmgsystems.mail.Testconfirm;
import com.vijaysankar.hmgsystems.randomnumber.Randomnumber;

import java.util.Random;

public class Testappointmentlist {
	public static int appid = 1001;
	public static void main(String[] args) throws Exception {

		Appointmentlist m= new Appointmentlist();
		Impappointment p=new Impappointment();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Appointment details \n");
		m.setAppid(Randomnumber.getrandom());
		System.out.println("Enter Patientid ");
		m.setPatientid(sc.nextInt());
		System.out.println("Enter Purpose ");
		m.setPurpose(sc.next());
		System.out.println("Enter Doctorid ");
		m.setDoctorid(sc.nextInt());
		System.out.println("Enter Appointment date ");
		String a=sc.next();
		LocalDate sr=LocalDate.parse(a);
		m.setAppdate(sr);
		System.out.println("Enter Appointment Time "); 
		m.setApptime(sc.next());
		System.out.println("Enter your mailId for notifications:");
		String mail=sc.next();
		p.addappointment(m);
		Testconfirm.main(m.getAppid(),m.getPatientid(),m.getDoctorid(),m.getAppdate(),m.getApptime(),mail);
		sc.close();	
	}
}
