package com.departments.controller;

import com.departments.model.Department;
import com.departments.model.Departments;
import com.departments.model.DepartmentsWithAvgSalary;
import com.departments.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by alex on 9.2.17.
 */
@Controller
@RequestMapping(value = "/department")
public class DepartmentController {

    private static final Logger log= LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        log.debug("Client  called  controller home  - '/' ");
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        return "home";
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String  list(Model uiModel){
//        log.info("Listing contacts");
//        List<Contact> contacts=contactService.findAllContacts();
//        uiModel.addAttribute("contacts",contacts);
//        log.info("No. of contacts = {}",contacts.size());
////            возвращаем имя представления , в данном случае /WEB-INF/views/contacts/list.jspx
//        return "contacts/list";
////        В конфигурации сервлета диспетчера в качестве распознавателя представлений указан
////        InternalResourceViewResolver, а файл имеет префикс /WEB-INF/views/ и суффикс .jspx.
////        В результате Spring МVС выберет для представления файл /WEB-INF/views/contacts/list.jspx.
//    }


    @RequestMapping(value = "/listDepartments",method = RequestMethod.GET)
    public String listDepartments(Model model){
        log.info("Listing departments");
        List<Department> listDepartments=departmentService.findAllDepartments();
        model.addAttribute("listDepartments",listDepartments);
        log.info("No. of departments = {}",listDepartments.size());
        return "listDepartments";
    }

    @ResponseBody
    @RequestMapping(value = "/listDepartmentsWitAvgSalary",method = RequestMethod.GET)
    public List<DepartmentsWithAvgSalary> listDepartmentsWitAvgSalary(){
        return  departmentService.findDepartmentsWithAvgSalary();
    }

    @ResponseBody
    @RequestMapping(value = "/getDepartment/{id}",method = RequestMethod.GET)
    public Department findContactById(@PathVariable Long id){
        return departmentService.findDepartmentById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/createDepartment",method = RequestMethod.POST)
    public Department create (@RequestBody Department department){
        log.debug("Create department " , department);
        departmentService.save(department);
        log.debug("Department create successfully with info{}", department );
        return department;
    }

    @ResponseBody
    @RequestMapping(value = "/createDepartments",method = RequestMethod.POST)
    public Departments departments(@RequestBody Departments departments){
        ArrayList<Department> departmentArrayList= departments.getDepartments();
        for (Department department:departmentArrayList){
            log.debug("Create departmentsDto " , department);
            departmentService.save(department);
            log.debug("Department create successfully with info{}", department );
        }
        return departments;
    }

    @ResponseBody
    @RequestMapping(value = "/updateDepartment/{id}",method = RequestMethod.PUT)
    public Department update (@RequestBody Department department, @PathVariable Long id){
        log.debug("Update department {}" , department);
        department.setId(id);
        departmentService.update(department);
        log.debug("Department updated successfully with info {}", department );
        return department;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteDepartment/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        Department department=departmentService.findDepartmentById(id);
        log.debug("Delete department {}",department);
        departmentService.delete(id);
        log.debug("Delete department successfully {}",department);
    }

}
