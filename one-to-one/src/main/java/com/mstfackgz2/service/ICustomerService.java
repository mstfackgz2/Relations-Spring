package com.mstfackgz2.service;

import java.util.List;

import com.mstfackgz2.dto.DtoCustomer;
import com.mstfackgz2.dto.DtoCustomerIU;
import com.mstfackgz2.entity.Customer;

public interface ICustomerService {

	public DtoCustomer saveCustomer(DtoCustomerIU customer);

	public DtoCustomer getCustomerById(Long id);
	
	public List<DtoCustomer> getAllCustomer();
	
	public  void deleteCustomerById(Long id);
	
	public DtoCustomer updateCustomer(Long id, DtoCustomerIU dtoCustomer);
	
}
