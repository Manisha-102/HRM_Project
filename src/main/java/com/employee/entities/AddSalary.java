package com.employee.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name="addSalary")
public class AddSalary 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int salaryId;
	private String employeeName;
	private String months;
	private double amount;
	
	
	@OneToOne(targetEntity = Employee.class)
	private Employee employee;
	
	public AddSalary() {
		super();
		
		
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}




	public AddSalary(int salaryId, String employeeName, String months, double amount) {
		super();
		this.salaryId = salaryId;
		this.employeeName = employeeName;
		this.months = months;
		this.amount = amount;
	}

	public int getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "AddSalary [salaryId=" + salaryId + ", employeeName=" + employeeName + ", months=" + months + ", amount="
				+ amount + "]";
	}
	
	
}
