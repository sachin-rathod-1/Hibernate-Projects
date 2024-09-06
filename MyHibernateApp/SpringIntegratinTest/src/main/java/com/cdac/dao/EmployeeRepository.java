package com.cdac.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cdac.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository <Employee, Long> 
{
	 
}