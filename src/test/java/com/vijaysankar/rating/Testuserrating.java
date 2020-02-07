package com.vijaysankar.rating;

import java.util.Scanner;

import com.vijaysankar.hmgsystems.userrating.Impuserrating;
import com.vijaysankar.hmgsystems.userrating.Userrating;

public class Testuserrating {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Impuserrating c= new Impuserrating();
		Userrating a=new Userrating();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter patient id");
		a.setPatient_id(sc.nextInt());
		System.out.println("enter doctor id");
		a.setDoctor_id(sc.nextInt());
		System.out.println("Rating out of 10");
		a.setRating(sc.nextInt());
		c.addrating(a);
		sc.close();
			
			
		}

	}


