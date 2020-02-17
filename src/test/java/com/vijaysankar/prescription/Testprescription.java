package com.vijaysankar.prescription;
import java.util.Scanner;
import com.vijaysankar.hmgsystems.prescription.Impprescription;
import com.vijaysankar.hmgsystems.prescription.Prescriptionlist;
public class Testprescription {
	public static void main(String[] args) throws Exception {
		Prescriptionlist presli=new Prescriptionlist();
		Impprescription presimp=new Impprescription();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter patient name:");
		presli.setPatientname(sc.next());
		System.out.println("Enter doctor name:");
		presli.setDoctorname(sc.next());
		System.out.println("Enter comments :");
		presli.setComments(sc.next());
		System.out.println("Any other fee: ");
		int a=sc.nextInt();
		presli.setTotalamt(a);
		presimp.getDoctorFee(presli.getDoctorname());
		presimp.addData(presli);
		sc.close();
	}
}
