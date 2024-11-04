package com.mstfackgz2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.mstfackgz2.dto.DtoCustomer;
import com.mstfackgz2.dto.DtoCustomerIU;

public interface ICustomerController {

	public DtoCustomer saveCustomer(DtoCustomerIU customer);
	public DtoCustomer getCustomerById(Long id);
	public List<DtoCustomer> getAllCustomer();
	public  void deleteCustomerById(Long id);
	public DtoCustomer updateCustomer(Long id, DtoCustomerIU dtoCustomerIU);
}
