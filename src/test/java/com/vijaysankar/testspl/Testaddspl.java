package com.vijaysankar.testspl;

import java.util.Scanner;

import com.vijaysankar.hmgsystems.splzations.Impspecialization;
import com.vijaysankar.hmgsystems.splzations.Splzationlist;

public class Testaddspl {

	public static void main(String[] args) throws Exception {
		
		Impspecialization impspl=new Impspecialization();
		Splzationlist splli= new Splzationlist();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Specialization details \n");
		System.out.println("Enter specializationid ");
		splli.setSplzationid(sc.nextInt());
		System.out.println("Enter Specialization name ");
		splli.setSplzationname(sc.next());
		impspl.addspecialization(splli);
		sc.close();
	}

}
