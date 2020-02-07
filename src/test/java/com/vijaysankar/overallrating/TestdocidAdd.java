package com.vijaysankar.overallrating;
import java.util.Scanner;
import com.vijaysankar.hmgsystems.overallrating.Impoverall;
import com.vijaysankar.hmgsystems.overallrating.Overallrating;
public class TestdocidAdd {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Impoverall c= new Impoverall();
		Overallrating a=new Overallrating();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter doctor id");
		a.setDoctor_id(sc.nextInt());
		c.add(a);
		sc.close();
	}
}
