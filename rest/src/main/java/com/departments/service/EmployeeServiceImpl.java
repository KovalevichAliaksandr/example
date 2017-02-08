package com.departments.service;

import com.departments.dao.DepartmentDao;
import com.departments.dao.EmployeeDao;
import com.departments.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by alex on 8.2.17.
 */
//@Repository
//@Transactional
//@Service(value = "contactService")
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger log= LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeDao employeeDao;


    public  EmployeeServiceImpl(EmployeeDao employeeDao){
        this.employeeDao=employeeDao;
    }
    @Override
    public Employee findEmployeeById(Long id) {
        Assert.notNull(id,"id must not be null");
        Assert.isTrue(id>0,"id must greater than 0 ");
        return employeeDao.findEmployeeById(id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDao.findAllEmployees();
    }

    @Override
    public Long save(Employee employee) {

        Assert.notNull(employee.getFirstName(),"First name must be not null");
        Assert.notNull(employee.getLastName(),"Last Name must be not null");
        Assert.isTrue(employee.getSalary()>=0,"salary must greater or equally than 0 ");
        Date today=new Date();
        Assert.isTrue(today.before(employee.getDob()),"Day of Birth  must be up to today ");
        Long id=employeeDao.save(employee);
        return id;
    }

    @Override
    public void delete(Long id) {
        employeeDao.delete(id);
    }

    @Override
    public void update(Employee employee) {

    }
}
