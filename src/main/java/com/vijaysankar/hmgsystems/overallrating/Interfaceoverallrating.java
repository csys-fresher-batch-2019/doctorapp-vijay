package com.vijaysankar.hmgsystems.overallrating;

import java.util.ArrayList;

public interface Interfaceoverallrating {
	
	public void syncrating(Overallrating o) throws Exception;
	public void add(Overallrating o) throws Exception;
	public ArrayList<Overallrating> viewrating() throws Exception;

}
