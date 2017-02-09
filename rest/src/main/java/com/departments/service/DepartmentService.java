package com.departments.service;

import com.departments.model.Department;

import java.util.List;

/**
 * Created by alex on 8.2.17.
 */

public interface DepartmentService {
    public Department findDepartmentById(Long id);
    public List<Department> findAllDepartments();
    public Long save (Department department);
    public void delete(Long id);
    public void update(Department department);
}
