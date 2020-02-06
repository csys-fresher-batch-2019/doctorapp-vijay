package com.vijaysankar.prescription;

import java.util.ArrayList;

import com.vijaysankar.hmgsystems.prescription.Impprescription;
import com.vijaysankar.hmgsystems.prescription.Prescriptionlist;

public class Testviewprescription {

	public static void main(String[] args) throws Exception  {
		
		Impprescription s=new Impprescription();
		ArrayList<Prescriptionlist> p=new ArrayList<Prescriptionlist>();
		p=s.viewData();
		for (Prescriptionlist li: p) 
		{
			System.out.println(li);	
	}
	}
	}
