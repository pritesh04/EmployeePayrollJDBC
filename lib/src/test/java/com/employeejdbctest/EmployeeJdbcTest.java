package com.employeejdbctest;

import java.sql.SQLException;

import org.junit.Test;

import com.employeepayrolljdbc.EmployeePayrollJdbc;
import com.employeepayrolljdbc.EmployeeService;
import com.sun.tools.javac.util.Assert;

public class EmployeeJdbcTest {
	EmployeePayrollJdbc employeePayrollJdbc;
	EmployeeService employeeService;
	
	
	@Test
	public void ifConnection_IsSuccessful_ShouldReturnTrue() {
		employeePayrollJdbc = new EmployeePayrollJdbc();
		Assert.assertTrue(employeePayrollJdbc.dbConnect()!=null);
	}
	
	@Test
	public void ifData_FromDataBase_ShouldReturnSize() throws SQLException{
		employeeService = new EmployeeService();
		String query = "select * from employee;";
		Integer res = employeeService.getQuery(query);
		Assert.assertEquals((Integer)4,res);
	}
	@Test
	public void updatedSalary_ShouldReturnTrue() throws SQLException{
		EmployeeService employeeService = new EmployeeService();
		int res = employeeService.updateData("Terissa",3000000.00);
		Assert.assertEquals(2,res);
	}
}
