/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greglturnquist.payroll;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static java.lang.Math.abs;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Entity // <1>
public class Employee {

	private @Id @GeneratedValue Long id; // <2>
	private String firstName;
	private String lastName;
	private String description;
	private LocalDate startDate;
	private int jobYears;
	private String email;

	private static final Pattern VALID_ISEP_EMAIL =
			Pattern.compile("^[A-Z0-9._%+-]+@isep.ipp.pt", Pattern.CASE_INSENSITIVE);

	public Employee() {
		//not called
	}

	public Employee(String firstName, String lastName, String description, LocalDate startDate, String email){

		if(stringIsValid(firstName)
				&& stringIsValid(lastName)
				&& stringIsValid(description)
				&& startDateIsValid(startDate)
				&& emailIsValid(email)){
			this.firstName = firstName;
			this.lastName = lastName;
			this.description = description;
			this.startDate = startDate;
			this.jobYears = calculateJobYears(startDate);
			this.email = email;
		}else{
			throw new IllegalArgumentException("Please verify input values");
		}

	}

	protected int calculateJobYears(LocalDate startDate) {
		LocalDate dateTo = LocalDate.now();
		Period workingPeriod = Period.between(startDate, dateTo);
		jobYears = workingPeriod.getYears();
		return jobYears;
	}

	protected boolean stringIsValid(String string) {
		return !string.trim().isEmpty();
	}

	protected boolean startDateIsValid(LocalDate startDate){
		return !startDate.isAfter(LocalDate.now());
	}

	protected boolean emailIsValid(String email){
		Matcher matcher = VALID_ISEP_EMAIL.matcher(email);
		return matcher.find();
	}







	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		if (!super.equals(object)) return false;
		Employee employee = (Employee) object;
		return java.util.Objects.equals(id, employee.id)
				&& java.util.Objects.equals(firstName, employee.firstName)
				&& java.util.Objects.equals(lastName, employee.lastName)
				&& java.util.Objects.equals(description, employee.description)
				&& java.util.Objects.equals(startDate, employee.startDate)
				&& java.util.Objects.equals(jobYears, employee.jobYears)
				&& java.util.Objects.equals(email, employee.email);
	}

	public int hashCode() {
		return Objects.hash(super.hashCode(), id, firstName, lastName, description, startDate, jobYears, email);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {return startDate;}

	public void setStartDate(LocalDate startDate) {this.startDate = startDate;}

	public int getJobYears() {return jobYears;}

	public String getEmail() {return email;}

	public void setEmail(String email) {this.email = email;}

	@Override
	public String toString() {
		return "Employee{" +
			"id=" + id +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", description='" + description + '\'' +
			", startDate='" + startDate + '\'' +
			", jobYears='" + jobYears + '\'' +
			", email='" + email + '\'' +
			'}';
	}



}
// end::code[]
