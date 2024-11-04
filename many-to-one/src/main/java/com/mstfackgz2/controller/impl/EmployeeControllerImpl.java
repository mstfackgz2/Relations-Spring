package com.mstfackgz2.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mstfackgz2.controller.IEmployeeController;
import com.mstfackgz2.dto.DtoEmployee;
import com.mstfackgz2.service.IEmployeeService;
@RestController
@RequestMapping(path = "/api/employee")
public class EmployeeControllerImpl implements IEmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping(path ="/list" )
	@Override
	public List<DtoEmployee> findAllEmployees() {
		return employeeService.findAllEmployees();
	}

}
