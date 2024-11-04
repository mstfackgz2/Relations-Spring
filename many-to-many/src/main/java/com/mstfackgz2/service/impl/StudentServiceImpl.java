package com.mstfackgz2.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mstfackgz2.dto.DtoCourse;
import com.mstfackgz2.dto.DtoStudent;
import com.mstfackgz2.entity.Course;
import com.mstfackgz2.entity.Student;
import com.mstfackgz2.repository.StudentRepository;
import com.mstfackgz2.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public DtoStudent getStudentById(Integer id) {

		DtoStudent dtoStudent = new DtoStudent();
		Optional<Student> optional = studentRepository.findById(id);
		
		if (optional.isEmpty()) {
			return null;
		}
		
		Student dbStudent = optional.get();
		BeanUtils.copyProperties(dbStudent, dtoStudent);
		
		if (dbStudent.getCourses() != null && !dbStudent.getCourses().isEmpty()) {
			for (Course course : dbStudent.getCourses()) {
				DtoCourse dtoCourse = new DtoCourse();
				BeanUtils.copyProperties(course, dtoCourse);
				
				dtoStudent.getCourses().add(dtoCourse);
			}
		}
		
		
		
		return dtoStudent;
	}

}
