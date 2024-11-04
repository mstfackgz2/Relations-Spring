package com.mstfackgz2.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mstfackgz2.controller.IHomeController;
import com.mstfackgz2.dto.DtoHome;
import com.mstfackgz2.services.IHomeService;


@RestController
@RequestMapping(path = "/api/home")
public class HomeControllerImpl  implements IHomeController{
	
	@Autowired
	private IHomeService homeService;
	
	
	@Override
	@GetMapping(path = "/get/{id}")
	public DtoHome findHomeById(@PathVariable(name = "id") Long id) {
		// TODO Auto-generated method stub
		return homeService.findHomeById(id);
	}

}
