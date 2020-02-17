package com.vijaysankar.hmgsystems;
import java.time.LocalDate;
import java.util.Scanner;
import com.vijaysankar.hmgsystems.patientreg.ImpPatients;
import com.vijaysankar.hmgsystems.patientreg.Patientreglist;
public class Testaddpatients {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ImpPatients impPat = new ImpPatients();
		Patientreglist patregli=new Patientreglist();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Registration details \n");
		System.out.println("Enter patient Name ");
		patregli.setPatientname(sc.next());
		System.out.println("Enter patient Adharcard number : ");
		patregli.setAdharno(sc.nextLong());
		System.out.println("Enter patient date of birth : ");
		String dob=sc.next();
		patregli.setDob(LocalDate.parse(dob));
		System.out.println("Enter patient Gender");
		patregli.setGender(sc.next());
		System.out.println("Enter patient phonenumber");
		patregli.setPhoneno(sc.nextLong());
		impPat.addpatient(patregli);
		sc.close();
	}
}
