package com.bridgelabz.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bridgelabz.employee.model.EmployeeDO;
import com.bridgelabz.employee.model.EmployeeEntity;
import com.bridgelabz.employee.model.ResponseDo;
import com.bridgelabz.employee.service.IEmployeePayrollService;


public class EmployeePayrollController {

	@Autowired
    private IEmployeePayrollService employeePayrollService;
    
    @PostMapping(value = "/add")
    public ResponseEntity<ResponseDo> addEmployee(@RequestBody EmployeeDO empDo){
        return new ResponseEntity<ResponseDo>(employeePayrollService.addEmployee(empDo), HttpStatus.OK);
    }
    
    @GetMapping(value = "/get")
    public ResponseEntity<List<EmployeeEntity>> getEmployeeList() {
        return new ResponseEntity<>(employeePayrollService.getEmployeeList(), HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseDo> deleteEmplyoee(@PathVariable int id) {
        return new ResponseEntity<ResponseDo>(employeePayrollService.deleteEmployee(id), HttpStatus.OK);
    }
    
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable int id) {
        return new ResponseEntity<>(employeePayrollService.getEmployeeByID(id), HttpStatus.OK);
    }
    
    @PutMapping(value ="/update/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeDO employeeDo, @PathVariable int id){
    	return new ResponseEntity<>(employeePayrollService.updateEmployeeData(id, employeeDo), HttpStatus.OK);
    }
}
