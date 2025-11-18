package student_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import student_management_system.repository.studentRepository;

@Service
public class StudentServiceImpl {
   
	@Autowired
	private studentRepository studentRepo;
	
	
}
