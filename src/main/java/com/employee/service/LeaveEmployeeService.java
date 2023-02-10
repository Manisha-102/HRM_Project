package com.employee.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeRepository;
import com.employee.dao.LeaveEmployeeRepository;
import com.employee.entities.Employee;
import com.employee.entities.LeaveEmployee;
import com.employee.entities.ProjectDetails;
import com.employee.request.RequestLeave;


@Service
public class LeaveEmployeeService
{
  
	@Autowired
	private LeaveEmployeeRepository leaveEmployeeRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	//Save LeaveEmployee
	public LeaveEmployee addLeaveEmployee(RequestLeave requestLeave)
	{
		Employee employee=employeeRepository.findById(requestLeave.getEmployeeId()).get();
		
		LeaveEmployee leave=new LeaveEmployee();
		leave.setFromDate(requestLeave.getFromDate());
		leave.setToDate(requestLeave.getToDate());
		leave.setReasonToLeave(requestLeave.getReasonToLeave());
		leave.setEmployee(employee);
		
	  LeaveEmployee	 leaveEmp=this.leaveEmployeeRepository.save(leave);
		return leaveEmp;
	
	}
	
	
	//Get LeaveEmployee By Id
	public Optional<LeaveEmployee>getLeaveEmployeeById(int leaveId)
	{
	 Optional<LeaveEmployee>	leaveEmp=leaveEmployeeRepository.findById(leaveId);
		return leaveEmp;
	}
	
	//Get All Leave 
	public List<LeaveEmployee> getAllLeaveEmployee()
		{

		List<LeaveEmployee>	list=	(List<LeaveEmployee>) this.leaveEmployeeRepository.findAll();
		return list;
			
		}
	
	//Update the Leave  
	public void updateLeave(LeaveEmployee leaveEmp, int leaveId)
	{
		leaveEmp.setLeaveId(leaveId);
		leaveEmployeeRepository.save(leaveEmp);
		
	}
	
	
	//Delete The Project 
	public void deleteLeaveEmployee(int leaveId)
	{
		leaveEmployeeRepository.deleteById(leaveId);
		
	}
	

	 public Page<LeaveEmployee> findLeavetByPagination(Pageable page)
	    {
	    	return leaveEmployeeRepository.findAll(page);
//	    	return null;
	    }
	
	
}
