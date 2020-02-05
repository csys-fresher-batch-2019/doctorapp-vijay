package com.vijaysankar.overallrating;

import java.util.ArrayList;

import com.vijaysankar.hmgsystems.overallrating.Impoverall;
import com.vijaysankar.hmgsystems.overallrating.Overallrating;

public class Testviewrating {

	public static void main(String[] args) throws Exception {
		Impoverall i=new Impoverall();
		ArrayList<Overallrating> o=new ArrayList<Overallrating>();
		o=i.viewrating();
		for(Overallrating rt:o) {
			System.out.println(rt);
		}
	}

}
