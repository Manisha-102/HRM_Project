package com.employee.dao;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.entities.*;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>
{

	@Query(value = "SELECT employee_id as employeeId,first_name as firstName,email_id as emailId from employee",nativeQuery = true)
	public List<Map<String,Object>> findNameAndEmail();

//	public void findByEmailId(String emailId);
	@Query(value = "SELECT email_id FROM employee where email_id=:emailId",nativeQuery = true)
	public Employee findByEmailID(String emailId);

}
