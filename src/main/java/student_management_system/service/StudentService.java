package student_management_system.service;

import jakarta.validation.Valid;
import student_management_system.dto.StudentRequest;
import student_management_system.dto.StudentResponse;

public interface StudentService {
  
	StudentResponse createStudent(@Valid StudentRequest request);
}
