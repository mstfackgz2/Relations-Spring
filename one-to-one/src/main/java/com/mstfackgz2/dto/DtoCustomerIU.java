package com.mstfackgz2.dto;

import com.mstfackgz2.entity.Adress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoCustomerIU {

	
	private String name;
	
	private String secretInfo;
	
	private DtoAdress adress;
	
	
}
