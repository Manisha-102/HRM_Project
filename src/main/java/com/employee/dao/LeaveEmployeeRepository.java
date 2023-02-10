package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.entities.LeaveEmployee;
@Repository
public interface LeaveEmployeeRepository extends JpaRepository<LeaveEmployee, Integer>
{

}
