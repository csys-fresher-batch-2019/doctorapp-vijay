package com.vijaysankar.testspl;

import java.util.ArrayList;

import com.vijaysankar.hmgsystems.splzations.Impspecialization;
import com.vijaysankar.hmgsystems.splzations.Splzationlist;

public class Testview {

	public static void main(String[] args) throws Exception {
		Impspecialization impspl=new Impspecialization();
		ArrayList<Splzationlist> sa= new ArrayList<>();
		sa=impspl.viewspl();
		
		for (Splzationlist spl: sa) 
		{
			System.out.println(spl);
		
	}
	}
	}
