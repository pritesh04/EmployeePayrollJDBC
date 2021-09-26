package com.employeepayrolljdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class EmployeeService {

	EmployeePayrollJdbc employeePayrollJdbc;
	
	public int getQuery(String query) throws SQLException {
		ResultSet queries = getQuerries(query);
		return printSet(queries);
	}
	
	public int updateData(String name,double value) throws SQLException {
		employeePayrollJdbc = EmployeePayrollJdbc.getInstance();
		Connection connection = employeePayrollJdbc.dbConnect();
		java.sql.Statement statement = connection.createStatement();
		String query = String.format("update payroll set basic_pay = '%.2f' where emp_id IN (select emp_id from employee where name = '%s');",value,name);
		return statement.executeUpdate(query);
	}
	
	public int updatePreparedData(String name,double value) throws SQLException {
		employeePayrollJdbc = EmployeePayrollJdbc.getInstance();
		Connection connection = employeePayrollJdbc.dbConnect();
		String query = String.format("update payroll set basic_pay = '%.2f' where emp_id IN (select emp_id from employee where name = '%s');",value,name);
		java.sql.PreparedStatement statement =  connection.prepareStatement(query);
		return statement.executeUpdate();
	}
	
	public ResultSet getQuerries(String query) throws SQLException {
		employeePayrollJdbc = EmployeePayrollJdbc.getInstance();
		Connection connection = employeePayrollJdbc.dbConnect();
		java.sql.Statement statement = connection.createStatement();
		
		return statement.executeQuery(query);
	}
	
	public int printSet(ResultSet queries) throws SQLException {
		int i=0;
		while(queries.next()) {
			i++;
			int emp_id = queries.getInt("emp_id");
			String name = queries.getString("name");
			long phone_number = queries.getLong("phone_number");
			LocalDate date = queries.getDate("start").toLocalDate();
			char gender = queries.getString("gender").charAt(0);
			System.out.println(emp_id+" "+name+" "+phone_number+" "+date+" "+gender+" ");
		}
		return i;
	}
}
