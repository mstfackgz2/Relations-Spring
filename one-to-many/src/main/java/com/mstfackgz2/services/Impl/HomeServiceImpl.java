package com.mstfackgz2.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mstfackgz2.dto.DtoHome;
import com.mstfackgz2.dto.DtoRoom;
import com.mstfackgz2.entity.Home;
import com.mstfackgz2.entity.Room;
import com.mstfackgz2.repository.HomeRepository;
import com.mstfackgz2.services.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService {

	@Autowired
	private HomeRepository homeRepository;
	

	@Override
	public DtoHome findHomeById(Long id) {
		
		Optional<Home> optional =  homeRepository.findById(id);
		
		if (optional.isEmpty()) {
			return null;
		}
		
		Home dbHome = optional.get();
		
		DtoHome dtoHome = new DtoHome();
		
		BeanUtils.copyProperties(dbHome, dtoHome);
		
		List<Room> dbRooms = optional.get().getRoom();
		
		if (dbRooms != null  && !dbRooms.isEmpty()) {
			for (Room room : dbRooms) {
				DtoRoom dtoRoom =new DtoRoom();
				BeanUtils.copyProperties(room, dtoRoom);
				dtoHome.getRoom().add(dtoRoom);
			}
		}
		
		return dtoHome;
		
	}
	
}
