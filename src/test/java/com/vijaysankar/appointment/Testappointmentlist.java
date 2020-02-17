package com.vijaysankar.appointment;

import java.time.LocalDate;
import java.util.Scanner;

import com.vijaysankar.hmgsystems.appointment.Appointmentlist;
import com.vijaysankar.hmgsystems.appointment.Impappointment;
import com.vijaysankar.hmgsystems.mail.Testconfirm;
import com.vijaysankar.hmgsystems.randomnumber.Randomnumber;

public class Testappointmentlist {
	public static int appid = 1001;
	public static void main(String[] args) throws Exception {

		Appointmentlist appli= new Appointmentlist();
		Impappointment impapp=new Impappointment();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Appointment details \n");
		appli.setAppid(Randomnumber.getrandom());
		System.out.println("Enter Patientid ");
		appli.setPatientid(sc.nextInt());
		System.out.println("Enter Purpose ");
		appli.setPurpose(sc.next());
		System.out.println("Enter Doctorid ");
		appli.setDoctorid(sc.nextInt());
		System.out.println("Enter Appointment date ");
		String a=sc.next();
		LocalDate sr=LocalDate.parse(a);
		appli.setAppdate(sr);
		System.out.println("Enter Appointment Time "); 
		appli.setApptime(sc.next());
		System.out.println("Enter your mailId for notifications:");
		String mail=sc.next();
		impapp.addappointment(appli);
		Testconfirm.main(appli.getAppid(),appli.getPatientid(),appli.getDoctorid(),appli.getAppdate(),appli.getApptime(),mail);
		sc.close();	
	}
}
