package com.cdac.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

public class Employees 
{
    private List<Employee> employeeList;
    
    public List<Employee> getEmployeeList() {
        if(employeeList == null) {
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }
 
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    
    public int add( int a, int b ) {
		return a + b;
	}
    
}
