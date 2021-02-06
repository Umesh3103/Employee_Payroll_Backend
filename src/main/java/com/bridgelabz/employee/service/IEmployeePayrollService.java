package com.bridgelabz.employee.service;

import java.util.List;

import com.bridgelabz.employee.model.EmployeeDO;
import com.bridgelabz.employee.model.EmployeeEntity;
import com.bridgelabz.employee.model.ResponseDo;

public interface IEmployeePayrollService {
	public ResponseDo addEmployee(EmployeeDO empReqDo);
	public List<EmployeeEntity> getEmployeeList();
	public ResponseDo deleteEmployee(int id);
	public EmployeeEntity getEmployeeByID(int id);
	public EmployeeEntity updateEmployeeData(int employeeId, EmployeeDO employeeDo);
}
