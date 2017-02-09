package com.departments;

import com.departments.dao.DepartmentDao;
import com.departments.dao.EmployeeDao;
import com.departments.model.Department;
import com.departments.model.Employee;
import com.departments.service.DepartmentService;
import com.departments.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by alex on 8.2.17.
 */
public class TestDepartmentsService {
    private static final Logger log= LoggerFactory.getLogger(TestDepartmentsDao.class);


    public static void testEmployeeService(EmployeeService employeeService) throws ParseException {
        Employee employee;
        log.info("=====================================Employee service ===========================================");
        log.info("=====================================Employee by id ===========================================");
        employee=employeeService.findEmployeeById(1L);
        log.info("Find employee by id= {} ",employee);
        log.info("=====================================List all employees ===========================================");
        List<Employee> employeeList=employeeService.findAllEmployees();
        log.info("List all employees = {} ",employeeList);
        log.info("=====================================Save  employee ===========================================");
        Employee employee1=new Employee();
        employee1.setFirstName("Alex");
        employee1.setLastName("Smirnov");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = format.parse("2014-05-03");
        employee1.setDob(date);
        employee1.setSalary(500);
        employee1.setIdDepartment(2L);
        log.info("Save employee with id = {} ",employeeService.save(employee1));
        log.info("=====================================Delete  employee ===========================================");
        employeeService.delete(15L);
        log.info("Delete employee with id = {} ",15L);
        log.info("=====================================Update  employee ===========================================");
        Employee employee2=employeeService.findEmployeeById(1L);
        employee2.setFirstName("New Name");
        employeeService.update(employee2);
        log.info("Update employee with id = {} ",1L);

    }
    public static void testDepartmentService(DepartmentService departmentService){
        Department department;
        log.info("=====================================Department service ===========================================");
        log.info("=====================================Department by id ===========================================");
        department=departmentService.findDepartmentById(1L);
        log.info("Find department by id= {} ",department);
        log.info("=====================================List all department ===========================================");
        List <Department> employeeList=departmentService.findAllDepartments();
        log.info("List all departments = {} ",employeeList);
        log.info("=====================================Save  department ===========================================");
        Department department1=new Department();
        department1.setNameDepartment("New department");
        log.info("Save department with id = {} ",departmentService.save(department1));
        log.info("=====================================Delete  department ===========================================");
        departmentService.delete(6L);
        log.info("Delete department with id = {} ",6L);
        log.info("=====================================Update  department ===========================================");
        Department department2=departmentService.findDepartmentById(1L);
        department2.setNameDepartment("New department");
        departmentService.update(department2);
        log.info("Update department with id = {} ",1L);
    }

    public static void main(String[] args) throws ParseException {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/data-source-mysql.xml");
        EmployeeService employeeService=(EmployeeService) applicationContext.getBean("employeeService");
        testEmployeeService(employeeService);
        DepartmentService departmentService=(DepartmentService) applicationContext.getBean("departmentService");
        testDepartmentService(departmentService);


    }
}
