package student_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import student_management_system.dto.StudentRequest;
import student_management_system.dto.StudentResponse;
import student_management_system.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class studentController {
    
	@Autowired
	private  StudentService studentService;
	
	public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentRequest request){
		
		StudentResponse response = studentService.createStudent(request);
		return ResponseEntity.ok(studentService.createStudent(request));
	}

	
}
