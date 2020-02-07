package com.vijaysankar.prescription;
import java.util.Scanner;
import com.vijaysankar.hmgsystems.prescription.Impprescription;
import com.vijaysankar.hmgsystems.prescription.Prescriptionlist;
public class Testprescription {
	public static void main(String[] args) throws Exception {
		Prescriptionlist L=new Prescriptionlist();
		Impprescription M=new Impprescription();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter patient name:");
		L.setPatientname(sc.next());
		System.out.println("Enter doctor name:");
		L.setDoctorname(sc.next());
		System.out.println("Enter comments :");
		L.setComments(sc.next());
		System.out.println("Any other fee: ");
		int a=sc.nextInt();
		L.setTotalamt(a);
		M.addData(L);
		sc.close();
	}
}
