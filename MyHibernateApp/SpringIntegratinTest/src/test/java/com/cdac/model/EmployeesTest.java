package com.cdac.model;

import org.aspectj.weaver.ast.Var;
import org.assertj.core.api.Assert;
import org.junit.*;

public class EmployeesTest {

	@Test
	public void addTest() {
		Employees methodVar = new Employees();
		Assert.assertEquals( 3, methodVar.add(1, 2) );
		
	}
}
