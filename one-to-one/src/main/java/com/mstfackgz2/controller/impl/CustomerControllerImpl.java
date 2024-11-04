package com.mstfackgz2.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mstfackgz2.controller.ICustomerController;
import com.mstfackgz2.dto.DtoCustomer;
import com.mstfackgz2.dto.DtoCustomerIU;
import com.mstfackgz2.service.ICustomerService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping(path = "/api/customer")
public class CustomerControllerImpl implements ICustomerController {

	@Autowired
	public ICustomerService customerService;
	
	@PostMapping(path = "/save")
	@Override
	public DtoCustomer saveCustomer(@RequestBody DtoCustomerIU customer) {
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping("/list/{id}")
	@Override
	public DtoCustomer getCustomerById(@PathVariable(name = "id") Long id) {
		return customerService.getCustomerById(id);
	}

	@GetMapping("/list")
	@Override
	public List<DtoCustomer> getAllCustomer() {
		return customerService.getAllCustomer();
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteCustomerById(@PathVariable(name = "id") Long id) {
		customerService.deleteCustomerById(id);
		
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public DtoCustomer updateCustomer(@PathVariable(name = "id") Long id, @RequestBody DtoCustomerIU dtoCustomerIU) {
		return customerService.updateCustomer(id, dtoCustomerIU);
	}
	
	

}
