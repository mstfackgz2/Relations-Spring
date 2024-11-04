package com.mstfackgz2.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mstfackgz2.dto.DtoDepartment;
import com.mstfackgz2.dto.DtoEmployee;
import com.mstfackgz2.entity.Employee;
import com.mstfackgz2.repository.EmployeeRepository;
import com.mstfackgz2.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public List<DtoEmployee> findAllEmployees() {
		List<Employee> employeeList =  employeeRepository.findAll();
		List<DtoEmployee> dtoEmployeeList = new ArrayList<>();
		if (!employeeList.isEmpty() && employeeList != null) {
			
			for (Employee employee : employeeList) {
				DtoEmployee dtoEmployee = new DtoEmployee();
				BeanUtils.copyProperties(employee, dtoEmployee);
				
				dtoEmployee.setDepartment(new DtoDepartment(employee.getDepartment().getId(),employee.getDepartment().getDepartmentName()));
				
				dtoEmployeeList.add(dtoEmployee);
				
				
			}
			return dtoEmployeeList;
			
			
		}
		
		
		
		
		return null;
	}



}
