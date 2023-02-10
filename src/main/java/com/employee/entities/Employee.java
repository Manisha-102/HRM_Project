package com.employee.entities;

import java.time.LocalDate;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity(name="employee")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int    employeeId;
	private String  firstName,  lastName;
	private String  contact,  emailId;
	private String  aadharCard, panCard;
	private String  bankName,   accountNumber, cifNumber;
	private String  experience;
	private String  previousCompanyName;
	private String  designation;
	private String  password;
	private String  gender;     
	private LocalDate dateOfBirth;
	private boolean enabled=true;
	
	
	
	@OneToMany(cascade =CascadeType.ALL)
	private List<Address> address;

	
	@OneToMany(cascade =CascadeType.ALL)
	private List<Qualification> qualification; 	
	
	public Employee() {
		super();
		
	}

	public Employee(int employeeId, String firstName, String lastName, String contact, String emailId,
			String aadharCard, String panCard, String bankName, String accountNumber, String cifNumber,
			String experience, String previousCompanyName, String designation, String password, String gender,
			LocalDate dateOfBirth, List<Address> address, List<Qualification> qualification) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.emailId = emailId;
		this.aadharCard = aadharCard;
		this.panCard = panCard;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.cifNumber = cifNumber;
		this.experience = experience;
		this.previousCompanyName = previousCompanyName;
		this.designation = designation;
		this.password = password;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.qualification = qualification;
	}

	
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCifNumber() {
		return cifNumber;
	}

	public void setCifNumber(String cifNumber) {
		this.cifNumber = cifNumber;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getPreviousCompanyName() {
		return previousCompanyName;
	}

	public void setPreviousCompanyName(String previousCompanyName) {
		this.previousCompanyName = previousCompanyName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Qualification> getQualification() {
		return qualification;
	}

	public void setQualification(List<Qualification> qualification) {
		this.qualification = qualification;
	}
	
	
	
  
}













