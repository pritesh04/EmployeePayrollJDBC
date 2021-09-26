package com.employeepayrolljdbc;

import java.sql.DriverManager;
import java.util.Enumeration;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class EmployeePayrollJdbc {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
		String userName = "root";
		String password = "1234";
		
		java.sql.Connection connection;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded!");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find driver in classpath",e);
		}

		listDrivers();
		try {
			System.out.println("Connecting to database:"+jdbcURL);
			connection = DriverManager.getConnection(jdbcURL,userName,password);
			System.out.println("Connection is successful"+connection);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void listDrivers() {
		Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
		while(driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println("  "+driverClass.getClass().getName());
		}
	}
}
