package com.employeepayrolljdbc;

import java.sql.DriverManager;
import java.util.Enumeration;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class EmployeePayrollJdbc {

	private static EmployeePayrollJdbc employeePayrollJdbc;
	public EmployeePayrollJdbc() {}

Connection connection;
	
	public Connection dbConnect() {
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
		String userName = "root";
		String password = "1234";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find driver ",e);
		}

		try {
			System.out.println("Connecting to database:"+jdbcURL);
			connection = (Connection) DriverManager.getConnection(jdbcURL,userName,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public static EmployeePayrollJdbc getInstance() {
		if (employeePayrollJdbc==null)
			employeePayrollJdbc = new EmployeePayrollJdbc();
		return employeePayrollJdbc;
	}
}
