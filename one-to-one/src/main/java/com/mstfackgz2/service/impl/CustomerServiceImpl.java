package com.mstfackgz2.service.impl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.weaving.DefaultContextLoadTimeWeaver;
import org.springframework.stereotype.Service;
import com.mstfackgz2.dto.DtoAdress;
import com.mstfackgz2.dto.DtoCustomer;
import com.mstfackgz2.dto.DtoCustomerIU;
import com.mstfackgz2.entity.Adress;
import com.mstfackgz2.entity.Customer;
import com.mstfackgz2.repository.CustomerRepository;
import com.mstfackgz2.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public DtoCustomer saveCustomer(DtoCustomerIU customerIU) {
		Customer customer = new Customer(); 
		
		BeanUtils.copyProperties(customerIU, customer);
		
		Adress adress = new Adress();	
		BeanUtils.copyProperties(customerIU.getAdress(), adress);
		customer.setAdress(adress);
		
		Customer savedCustomer = customerRepository.save(customer);
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAdress dtoAdress = new DtoAdress();
		
		BeanUtils.copyProperties(savedCustomer, dtoCustomer);
		BeanUtils.copyProperties(savedCustomer.getAdress(), dtoAdress);
		
		dtoCustomer.setAdress(dtoAdress);
		
		return dtoCustomer;
	}


	@Override
	public DtoCustomer getCustomerById(Long id) {
	    Optional<Customer> optional = customerRepository.findById(id);

	    if (optional.isEmpty()) {
	        return null;
	    }
	    Customer customer = optional.get();
	    DtoCustomer dtoCustomer = new DtoCustomer();
	    BeanUtils.copyProperties(customer, dtoCustomer);

	    Adress adress = customer.getAdress();
	    if (adress != null) {
	        DtoAdress dtoAdress = new DtoAdress();
	        BeanUtils.copyProperties(adress, dtoAdress);
	        dtoCustomer.setAdress(dtoAdress);
	    }
	    return dtoCustomer;
	}

	@Override
	public List<DtoCustomer> getAllCustomer() {
		List<Customer> customerList = new ArrayList<>();
		customerList = customerRepository.findAll();
		if (customerList!= null && !customerList.isEmpty()) {
			List<DtoCustomer> dtoCustomerList = new ArrayList<>();
		
			for (Customer customer : customerList) {
				DtoCustomer dtoCustomer = new DtoCustomer();
				DtoAdress dtoAdress = new DtoAdress();
				
				BeanUtils.copyProperties(customer, dtoCustomer);
				BeanUtils.copyProperties(customer.getAdress(), dtoAdress);
				
				dtoCustomer.setAdress(dtoAdress);
				dtoCustomerList.add(dtoCustomer);
			}
			return dtoCustomerList;
		}
		return null;
	}


	@Override
	public void deleteCustomerById(Long id){
		customerRepository.deleteById(id);
	}


	@Override
	public DtoCustomer updateCustomer(Long id, DtoCustomerIU dtoCustomerIU) {
		Optional<Customer> optional = customerRepository.findById(id);
		if (optional.isPresent()) {
			Customer customer = optional.get();
			Adress adress = customer.getAdress();
			
			BeanUtils.copyProperties(dtoCustomerIU, customer);
			BeanUtils.copyProperties(dtoCustomerIU.getAdress(), adress);
			
			Customer updateCustomer= customerRepository.save(customer);
			
			DtoCustomer returnCustomer = new DtoCustomer() ;
			
			BeanUtils.copyProperties(updateCustomer, returnCustomer);
			DtoAdress dtoAdress = new DtoAdress();
			
			
			BeanUtils.copyProperties(updateCustomer.getAdress(), dtoAdress);
			
			returnCustomer.setAdress(dtoAdress);
			
			
			
			return returnCustomer;
		}

		
		
		
		return null;
	}


}
