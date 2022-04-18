package com.springboot.workers.crudapi.model;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Worker implements Comparable<Worker> {
    private int workerId;
    private String firstName;
    private String lastName;
    private int salary;
    private Timestamp joiningDate;
    private String department;
    private String email;

    @Override
    public int compareTo(Worker other) {
        return this.workerId - other.workerId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode()) + workerId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Worker other = (Worker) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (workerId != other.workerId)
            return false;
        return true;
    }
    
    // use Timesatamp instead of date if we want time also because sql date does not support time so it just normalizes the values to 0
    public Worker(int workerId, String firstName, String lastName, int salary, Timestamp joiningDate, String department,
            String email) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.department = department;
        this.email = email;
    }

    public Worker(int workerId, String firstName, String lastName, int salary, String department,
            String email) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
        this.email = email;
    }

    public Worker(int workerId, String firstName, String email) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.email = email;
    }

    public Worker(int workerId, String firstName, Timestamp joiningDate, String email) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.joiningDate = joiningDate;
        this.email = email;
    }

   

    public Worker() {
		super();
	}

	public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Timestamp getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) throws ParseException {
    	
    	 //first convert string to java.util.Date object using SimpleDateFormat

    	SimpleDateFormat sdf =	new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
    	java.util.Date myDate = sdf.parse(joiningDate);
    	System.out.println(myDate);
    			
    	// now 
    	 this.joiningDate = new Timestamp(myDate.getTime());

    	 
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Worker [department=" + department + ", email=" + email + ", firstName=" + firstName
                + ", joiningDate=" + joiningDate + ", lastName=" + lastName + ", salary=" + salary + ", workerId="
                + workerId + "]";
    }

}
