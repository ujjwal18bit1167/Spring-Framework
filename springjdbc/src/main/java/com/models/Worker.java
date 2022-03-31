package com.models;

import java.sql.Date;

public class Worker {
    private int worker_id;
    private String first_name;
    private String last_name;
    private int salary;
    private Date joining_date;
    private String department;
    private String email;

    // here date is java sql date
    public Worker(int worker_id, String first_name, String last_name, int salary, Date date,
            String department,
            String email) {
        this.worker_id = worker_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
        this.joining_date = date;
        this.department = department;
        this.email = email;
    }

    public Worker(int worker_id) {
        this.worker_id = worker_id;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(Date joining_date) {
        this.joining_date = joining_date;
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
        return "Worker [department=" + department + ", email=" + email + ", first_name=" + first_name
                + ", joining_date=" + joining_date + ", last_name=" + last_name + ", salary=" + salary + ", worker_id="
                + worker_id + "]";
    }

    public Worker(int worker_id, String email) {
        this.worker_id = worker_id;
        this.email = email;
    }
}
