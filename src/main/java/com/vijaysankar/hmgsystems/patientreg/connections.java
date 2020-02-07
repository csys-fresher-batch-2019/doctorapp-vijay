package com.vijaysankar.hmgsystems.patientreg;

import java.sql.Connection;
import java.sql.DriverManager;

public class connections {
	public static Connection TestConnections() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		System.out.println(connection);
		return connection;
	}
}
