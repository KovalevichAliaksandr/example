package com.departments;

import com.departments.dao.DepartmentDao;
import com.departments.dao.EmployeeDao;
import com.departments.model.Department;
import com.departments.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by alex on 7.2.17.
 */
public class TestDepartment {
    private static final Logger log= LoggerFactory.getLogger(TestDepartment.class);


    public static void testEmployeeDao(EmployeeDao employeeDao){
        Employee employee;
        log.info("=====================================Employee by id ===========================================");
        employee=employeeDao.findEmployeeById(1L);
        log.info("Find employee by id= {} ",employee);
        log.info("=====================================List all employees ===========================================");
        List <Employee> employeeList=employeeDao.findAllEmployees();
        log.info("List all employees = {} ",employeeList);
        log.info("=====================================Save  employee ===========================================");
        Employee employee1=new Employee();
        employee1.setFirstName("Alex");
        employee1.setLastName("Smirnov");
        employee1.setDob(new Date());
        employee1.setSalary(-500);
        employee1.setIdDepartment(2L);
        log.info("Save employee with id = {} ",employeeDao.save(employee1));
        log.info("=====================================Delete  employee ===========================================");
        employeeDao.delete(15L);
        log.info("Delete employee with id = {} ",15L);
        log.info("=====================================Update  employee ===========================================");
        Employee employee2=employeeDao.findEmployeeById(1L);
        employee2.setFirstName("New Name");
        employeeDao.update(employee2);
        log.info("Update employee with id = {} ",1L);

    }
    public static void testDepartmentDao(DepartmentDao departmentDao){
        Department department;
        log.info("=====================================Employee by id ===========================================");
        department=departmentDao.findDepartmentById(1L);
        log.info("Find department by id= {} ",department);
        log.info("=====================================List all department ===========================================");
        List <Department> employeeList=departmentDao.findAllDepartment();
        log.info("List all departments = {} ",employeeList);
        log.info("=====================================Save  department ===========================================");
        Department department1=new Department();
        department1.setNameDepartment("New department");
        log.info("Save department with id = {} ",departmentDao.save(department1));
        log.info("=====================================Delete  department ===========================================");
        departmentDao.delete(6L);
        log.info("Delete department with id = {} ",6L);
        log.info("=====================================Update  department ===========================================");
        Department department2=departmentDao.findDepartmentById(1L);
        department2.setNameDepartment("New department");
        departmentDao.update(department2);
        log.info("Update department with id = {} ",1L);
    }

    public static void main(String[] args) {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/data-source-mysql.xml");
        EmployeeDao employeeDao=(EmployeeDao) applicationContext.getBean("employeeDao");
        testEmployeeDao(employeeDao);
        DepartmentDao departmentDao=(DepartmentDao) applicationContext.getBean("departmentDao");
        testDepartmentDao(departmentDao);
//        ContactService contactService=(ContactService) applicationContext.getBean("contactService");

    }
}
