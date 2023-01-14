package com.springproject.Springbootproject.service;

import com.springproject.Springbootproject.entity.Department;
import com.springproject.Springbootproject.exceptions.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {
  public Department saveDepartment(Department department);

  public List<Department> fetchDepartmentList();


 public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

 public void deleteDepartmentById(Long departmentId);

   public Department updateDepartmentById(Long departmentId, Department department);

   public Department fetchDepartmentByName(String departmentName);

}
