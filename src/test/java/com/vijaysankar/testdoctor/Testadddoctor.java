package com.vijaysankar.testdoctor;

import java.util.Scanner;

import com.vijaysankar.hmgsystems.doctors.Doctorlist;
import com.vijaysankar.hmgsystems.doctors.Impdoctor;

public class Testadddoctor {
	public static void main(String[] args) throws Exception {

	
	Impdoctor i= new Impdoctor();
	Doctorlist d= new Doctorlist();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter doctor details \n");
	System.out.println("Enter doctorid ");
	d.doctorid=sc.nextInt();
	System.out.println("Enter doctor name : ");
	d.doctorname=sc.next();
	System.out.println("Enter specializationid : ");
	d.splzationid=sc.nextInt();
	System.out.println("Enter consulting fee ");
	d.consultingfee=sc.nextInt();
	
	i.adddoctor(d);
	sc.close();

}
}

