package com.employee.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.APIResponse;
import com.employee.entities.*;
import com.employee.request.ProjectRequest;
import com.employee.service.*;

@RestController
@RequestMapping("addproject")
@CrossOrigin("*")
public class ProjectDetailsController 
{
	
	@Autowired
    private ProjectDetailsService projectDetailsService;
	
	
	// Add Projects  
	@PostMapping("/saveproject")
	public ResponseEntity<ProjectDetails> addProject(@RequestBody ProjectRequest projectRequest )
	{
	 try
	    {
	        ProjectDetails pdetails=projectDetailsService.addProjectDetails(projectRequest);
	        return ResponseEntity.of(Optional.of(pdetails));
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	
	}
	
	
	//Get ProjectDetails By Id
	@GetMapping("/getpro/{projectId}")
	public ResponseEntity<Optional<ProjectDetails>> findProjectById(@PathVariable ("projectId") int projectId)
	{
	 Optional<ProjectDetails>	pjDetails=projectDetailsService.getProjectDetailsById(projectId);
	 
	 if(pjDetails==null)
	 {
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	 }else
	 {
		 return ResponseEntity.of(Optional.of(pjDetails));
	 }
	}

	
	
	//Get all Projects
	@GetMapping("/getp")
	 public ResponseEntity<List<ProjectDetails>> findAllProject()
	 {
	   List<ProjectDetails> pjDetails=projectDetailsService.findAllProject();
		
	   if(pjDetails.size()<=0)
	   {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	   }
	  return ResponseEntity.status(HttpStatus.CREATED).body(pjDetails);
	}
	
	
   //Update Projects
	@PutMapping("/updatepro/{projectId}")
	public ResponseEntity<ProjectDetails> updateProjectById(@PathVariable ("projectId") int projectId, @RequestBody ProjectDetails projectsDetails)
	{
		try
		{
		projectDetailsService.updateProjects(projectsDetails, projectId);
		return  ResponseEntity.ok(null);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
    //Delete Project by Id
    @DeleteMapping("/{projectId}")	
	public ResponseEntity<ProjectDetails> deleteProjectById(@PathVariable ("projectId") int projectId)
	{
    	try
    	{
		this.projectDetailsService.deleteProject(projectId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
	}
    
    @GetMapping("/getproject")
    public Page<ProjectDetails> getProjectWithPagination(Pageable page ){
    	
    	return projectDetailsService.findProjectByPagination(page);
    	
//    	return new APIResponse<> (projectWithPagination.getSize(),projectWithPagination);
    }
}
