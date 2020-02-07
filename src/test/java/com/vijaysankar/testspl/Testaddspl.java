package com.vijaysankar.testspl;

import java.util.Scanner;

import com.vijaysankar.hmgsystems.splzations.Impspecialization;
import com.vijaysankar.hmgsystems.splzations.Splzationlist;

public class Testaddspl {

	public static void main(String[] args) throws Exception {
		
		Impspecialization s=new Impspecialization();
		Splzationlist s1= new Splzationlist();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Specialization details \n");
		System.out.println("Enter specializationid ");
		s1.setSplzationid(sc.nextInt());
		System.out.println("Enter Specialization name ");
		s1.setSplzationname(sc.next());
		s.addspecialization(s1);
		sc.close();
	}

}
