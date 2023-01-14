package com.springproject.Springbootproject.controller;

import com.springproject.Springbootproject.entity.Department;
import com.springproject.Springbootproject.exceptions.DepartmentNotFoundException;
import com.springproject.Springbootproject.service.DepartmentService;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService; //Spring automatically will create object

    private final Logger LOGGER=LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
     // DepartmentService service= new DepartmentServiceImpl(); //if we dont to create object by own spring boot automaticaly created.
       return departmentService.saveDepartment(department);
  }

  @GetMapping("/departments")
  public List<Department> fetchDepartmentList(){
      LOGGER.info("Inside fetchDepartmentList of DepartmentController");
      return departmentService.fetchDepartmentList();
  }

  @GetMapping("/departments/{id}")
  public Department fetchDepartmentById(@PathVariable("id")Long departmentId) throws DepartmentNotFoundException {
      LOGGER.info("Inside fetchDepartmentListById of DepartmentController");
      return departmentService.fetchDepartmentById(departmentId);
  }

  @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
      LOGGER.info("Inside deleteDepartmentById of DepartmentController");
      departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully!!";
    }

  @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id")Long departmentId,@RequestBody Department department){
      LOGGER.info("Inside updateDepartmentById of DepartmentController");
      return  departmentService.updateDepartmentById(departmentId,department);
    }


    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside fetchDepartmentByName of DepartmentController");
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
