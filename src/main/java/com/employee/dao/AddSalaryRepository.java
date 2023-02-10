package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entities.AddSalary;
@Repository
public interface AddSalaryRepository extends JpaRepository<AddSalary, Integer>
{

}
