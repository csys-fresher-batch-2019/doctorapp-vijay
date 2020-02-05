package com.vijaysankar.testdoctor;

import java.util.ArrayList;

import com.vijaysankar.hmgsystems.doctors.Doctorlist;
import com.vijaysankar.hmgsystems.doctors.Impdoctor;

public class Testviewdoctor {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Impdoctor o=new Impdoctor();
		ArrayList<Doctorlist> s1= new ArrayList<Doctorlist>();
		s1=o.viewdoctor();
		for(Doctorlist d:s1) {
			System.out.println(d);
		}
		

	}

}
