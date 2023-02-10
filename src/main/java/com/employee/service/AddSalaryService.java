package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.dao.AddSalaryRepository;
import com.employee.dao.EmployeeRepository;
import com.employee.entities.AddSalary;
import com.employee.entities.Employee;
import com.employee.request.AddSalaryRequest;


@RequestMapping(name="addsalary")
@Service
public class AddSalaryService
{
	@Autowired
	private AddSalaryRepository addSalaryRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//Add salary
	public AddSalary saveSalary(AddSalaryRequest addSalaryRequest)
	{
		
	   Employee employee=employeeRepository.findById(addSalaryRequest.getEmployeeId()).get();
	   AddSalary addSalary=new AddSalary();
	   
	   addSalary.setEmployeeName(addSalaryRequest.getEmployeeName());
	   addSalary.setAmount(addSalaryRequest.getAmount());
	   addSalary.setMonths(addSalaryRequest.getMonths());
	   
	   addSalary.setEmployee(employee);
	   
	   AddSalary add=addSalaryRepository.save(addSalary);
	   
	   return add;
		
	}
	
	//Get Salary By Id
	public Optional<AddSalary> getSalaryById(int salaryId)
	{
	   Optional<AddSalary> salary=this.addSalaryRepository.findById(salaryId);
		return salary;
	}
	
	
	
	
	
	//Show All Salary
	public List<AddSalary> getAllSalaryDetails()
	{
	 List<AddSalary> list=(List<AddSalary>) this.addSalaryRepository.findAll();
		return list;
	}
		
	//Update Salary
	public void updateSalary(AddSalary addSalary, int salaryId)
		{
			addSalary.setSalaryId(salaryId);
			addSalaryRepository.save(addSalary);
			
		}
		
		
		//Delete The Salary
		public void deleteSalary(int salaryId)
		{
			addSalaryRepository.deleteById(salaryId);
			
		}
		
		public Page <AddSalary> findAddSlaryByPagination (Pageable page){
			
			return addSalaryRepository.findAll(page);
			
		}
}
