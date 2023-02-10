package com.employee.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entities.LeaveEmployee;
import com.employee.entities.ProjectDetails;
import com.employee.request.RequestLeave;
import com.employee.service.LeaveEmployeeService;

@RestController
@RequestMapping("addLeave")
public class LeaveEmployeeController
{
	@Autowired
	private LeaveEmployeeService leaveEmployeeService;
	

	
	//Add Leave
	@PostMapping("/saveleave")
	public LeaveEmployee addLeave(@RequestBody RequestLeave leaveEmployee)
	{
	  return leaveEmployeeService.addLeaveEmployee(leaveEmployee);
	}
	
	
	//Get LeaveEmployee By Id
	@GetMapping("/getlev/{leaveId}")
	public ResponseEntity<Optional<LeaveEmployee>>  findLeaveById(@PathVariable ("leaveId") int leaveId)
	{
		
		Optional<LeaveEmployee> leaveEmp=this.leaveEmployeeService.getLeaveEmployeeById(leaveId);
		
		if(leaveEmp==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else
		{
		return ResponseEntity.of(Optional.of(leaveEmp));
		}
	}

	
	
	
	
	
	
  //Get All LeaveEmployee
   @GetMapping("/getallleave")
   public ResponseEntity<List<LeaveEmployee>> getAllLeave()
   {
	 try
	 {
	  List<LeaveEmployee> list=leaveEmployeeService.getAllLeaveEmployee();
	  return ResponseEntity.of(Optional.of(list));	
	 }catch(Exception e)
	 {
		 e.printStackTrace();
		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	 }
		   
   }
   
   //Update Leave
  	@PutMapping("/updateleave/{leaveId}")
  	public ResponseEntity<ProjectDetails> updateProjectById(@RequestBody LeaveEmployee leaveEmployee, @PathVariable ("leaveId") int leaveId)
  	{
  		try
  		{
  		leaveEmployeeService.updateLeave(leaveEmployee, leaveId);
  		return  ResponseEntity.ok(null);
  		}catch(Exception e)
  		{
  			e.printStackTrace();
  			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  		}
  	}
  	
  	
      //Delete Leave by Id
      @DeleteMapping("/leaveemployee/{leaveId}")	
  	public ResponseEntity<LeaveEmployee> deleteProjectById(@PathVariable ("leaveId") int leaveId)
  	{
      	try
      	{
  		this.leaveEmployeeService.deleteLeaveEmployee(leaveId);
  		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
      	}catch(Exception e)
      	{
      		e.printStackTrace();
      		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      	}
	}
      
      
      @GetMapping("/getleave")
      public Page<LeaveEmployee> getProjectWithPagination(Pageable page ){
      	
      	return leaveEmployeeService.findLeavetByPagination(page);
      	
//      	return new APIResponse<> (projectWithPagination.getSize(),projectWithPagination);
      }
}















