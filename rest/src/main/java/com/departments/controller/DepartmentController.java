package com.departments.controller;

import com.departments.model.Department;
import com.departments.model.Departments;
import com.departments.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by alex on 9.2.17.
 */
@Controller
@RequestMapping(value = "/department")
public class DepartmentController {

    private static final Logger log= LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    DepartmentService departmentService;

    @ResponseBody
    @RequestMapping(value = "/listDepartments",method = RequestMethod.GET)
    public Departments listData(){
        return new Departments((ArrayList<Department>) departmentService.findAllDepartments());
    }

//    @ResponseBody
//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    public Contact findContactById(@PathVariable Long id){
//        return contactService.findById(id);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/",method = RequestMethod.POST)
//    public Contact create (@RequestBody Contact contact){
//        log.info("Create contact " , contact);
//        contactService.save(contact);
//        log.info("Contact create successfully with info{}", contact );
//        return contact;
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/createContacts",method = RequestMethod.POST)
//    public Contacts createListContacts(@RequestBody Contacts  contacts){
//        ArrayList<Contact> contactArrayList=contacts.getContacts();
//        for (Contact contact:contactArrayList){
//            log.info("Create contact " , contact);
//            contactService.save(contact);
//            log.info("Contact create successfully with info{}", contact );
//        }
//        return contacts;
//
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
//    public Contact update (@RequestBody Contact contact, @PathVariable Long id){
//        log.info("Update contact {}" , contact);
//        contactService.save(contact);
//        log.info("Contact updated successfully with info {}", contact );
//        return contact;
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
//    public void delete(@PathVariable Long id){
//        Contact contact=contactService.findById(id);
//        log.info("Delete contact {}",contact);
//        contactService.delete(contact);
//        log.info("Delete contact successfully {}",contact);
//    }

}
