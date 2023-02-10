package com.employee.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.employee.entities.ProjectDetails;

public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails,Integer> 
{


}
