package com.departments.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by alex on 7.2.17.
 */
public class Employee {
    @NotNull
    private Long id;

    @NotNull
    @Size(min = 1,max = 45,message="first name should be between 1 - 45 symbols")
    private String firstName;

    @NotNull
    @Size(min = 1,max = 45,message="last name should be between 1 - 45 symbols")
    private String lastName;

    @Past
    private Date dob;

    @Min(value = 0,message="salary  should be  >=0 ")
    private Integer salary;

    @NotNull
    private Long idDepartment;

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Long idDepartment) {
        this.idDepartment = idDepartment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", salary=" + salary +
                ", idDepartment=" + idDepartment +
                '}';
    }
}
