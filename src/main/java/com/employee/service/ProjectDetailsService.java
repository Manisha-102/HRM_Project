package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeRepository;
import com.employee.dao.ProjectDetailsRepository;
import com.employee.entities.*;
import com.employee.request.ProjectRequest;

@Service
public class ProjectDetailsService
{

	@Autowired
	private ProjectDetailsRepository projectDetailsRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
     
	// Project Save
	public ProjectDetails addProjectDetails(ProjectRequest projectRequest)
	{
		Employee employee=employeeRepository.findById(projectRequest.getEmployeeId()).get();
		
		ProjectDetails pro=new ProjectDetails();
		pro.setProjectName(projectRequest.getProjectName());
		pro.setClientName(projectRequest.getClientName());
		pro.setDevelopingTechnology(projectRequest.getDevelopingTechnology());
		pro.setDatabaseTechnology(projectRequest.getDatabaseTechnology());
		pro.setTeamLeader(projectRequest.getTeamLeader());
		pro.setFromDate(projectRequest.getFromDate());
		pro.setToDate(projectRequest.getToDate());
		pro.setEmployee(employee);
		
		ProjectDetails proDetail=this.projectDetailsRepository.save(pro);
		return proDetail;
	}

	
	//Get ProjectDetails by Id
		public Optional<ProjectDetails> getProjectDetailsById(int pId)
	{
		Optional<ProjectDetails> projectDetails=null;
		try
		{
	    projectDetails=this.projectDetailsRepository.findById(pId);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return projectDetails;
       		
	}
	
	
	//Get All projects 
	public List<ProjectDetails> findAllProject()
	{
		
	  List<ProjectDetails> list=(List<ProjectDetails>) projectDetailsRepository.findAll();
		 
	  return list;
		
	}

	//Update The Project
	public void updateProjects(ProjectDetails pjDetails, int pId)
	{
		pjDetails.setProjectId(pId);
		projectDetailsRepository.save(pjDetails);
		
	}
	
	
	//Delete The Project 
	public void deleteProject(int pId)
	{
		projectDetailsRepository.deleteById(pId);
		
	}
	
	 public Page<ProjectDetails> findProjectByPagination(Pageable page)
	    {
	    	return projectDetailsRepository.findAll(page);
//	    	return null;
	    }

	
}











