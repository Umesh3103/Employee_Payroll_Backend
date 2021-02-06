package com.bridgelabz.employee.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bridgelabz.employee.exception.BadRequestException;
import com.bridgelabz.employee.exception.NotFoundException;
import com.bridgelabz.employee.model.EmployeeDO;
import com.bridgelabz.employee.model.EmployeeEntity;
import com.bridgelabz.employee.model.ResponseDo;
import com.bridgelabz.employee.repository.EmployeeRepository;
import com.bridgelabz.employee.service.IEmployeePayrollService;

@Service
public class EmployeePayrollServiceImpl implements IEmployeePayrollService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ResponseDo addEmployee(EmployeeDO empDo) {

		if (empDo == null) {
			throw new BadRequestException("Name is not Proper");
		}
		EmployeeEntity empEntity = new EmployeeEntity();
		empEntity = this.convertEntity(empEntity, empDo);
		empEntity = employeeRepository.save(empEntity);
		if (empEntity != null) {
			return new ResponseDo("Successfully data inserted");
		} else {
			return new ResponseDo("Failed to insert the Data");
		}

	}

	@Override
	public List<EmployeeEntity> getEmployeeList() {
		return employeeRepository.findAll();
		}

	@Override
	public ResponseDo deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		return new ResponseDo("Employee Deleteed Successfully..!!");
	}

	@Override
	public EmployeeEntity getEmployeeByID(int id) {
		return employeeRepository.findById(id)
				.orElseThrow(()-> new NotFoundException("User not found with Id: "+id));
	}
	
	@Override
	  public EmployeeEntity updateEmployeeData(int employeeId, EmployeeDO employeeDo) {
	    EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
	        .orElseThrow(() -> new NotFoundException("User not found with this Id: " + employeeId));
	    employeeEntity = this.convertEntity(employeeEntity, employeeDo);
	    employeeEntity.setId(employeeId);
	    return employeeRepository.save(employeeEntity);
	  }
	
	private EmployeeDO convertobj(EmployeeEntity employee) {
		EmployeeDO emp = new EmployeeDO();
		emp.setName(employee.getName());
		emp.setDepartment(employee.getDepartment());
		emp.setSalary(employee.getSalary());
		emp.setGender(employee.getGender());
		emp.setImagePath(employee.getImagePath());
		emp.setStartDate("");
		emp.setNotes(employee.getNotes());
		return emp;
	}
	
	private EmployeeEntity convertEntity(EmployeeEntity empEntity, EmployeeDO employeeDo) {
		empEntity.setName(employeeDo.getName());
		empEntity.setDepartment(employeeDo.getDepartment());
		empEntity.setSalary(employeeDo.getSalary());
		empEntity.setGender(employeeDo.getGender());
		empEntity.setImagePath(employeeDo.getImagePath());
		empEntity.setStartDate(new Date());
		empEntity.setNotes(employeeDo.getNotes());
		return empEntity;
	}
}
