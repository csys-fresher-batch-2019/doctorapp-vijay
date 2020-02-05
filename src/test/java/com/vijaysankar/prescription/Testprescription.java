package com.vijaysankar.prescription;

import java.util.Scanner;

import com.vijaysankar.hmgsystems.prescription.Impprescription;
import com.vijaysankar.hmgsystems.prescription.Prescriptionlist;

public class Testprescription {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Prescriptionlist L=new Prescriptionlist();
		Impprescription M=new Impprescription();
		Scanner sc=new Scanner(System.in);
		L.patientname=sc.next();
		L.doctorname=sc.next();
		L.comments=sc.next();
		System.out.println("Any other fee: ");
		int a=sc.nextInt();
		L.totalamt=a;
		M.addData(L);

	}

}
