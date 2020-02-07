package com.vijaysankar.hmgsystems;
import java.time.LocalDate;
import java.util.Scanner;
import com.vijaysankar.hmgsystems.patientreg.ImpPatients;
import com.vijaysankar.hmgsystems.patientreg.Patientreglist;
public class Testaddpatients {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ImpPatients obj = new ImpPatients();
		Patientreglist p=new Patientreglist();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Registration details \n");
		System.out.println("Enter patient Name ");
		p.setPatientname(sc.next());
		System.out.println("Enter patient Adharcard number : ");
		p.setAdharno(sc.nextLong());
		System.out.println("Enter patient date of birth : ");
		String dob=sc.next();
		p.setDob(LocalDate.parse(dob));
		System.out.println("Enter patient Gender");
		p.setGender(sc.next());
		System.out.println("Enter patient phonenumber");
		p.setPhoneno(sc.nextLong());
		obj.addpatient(p);
		sc.close();
	}
}
