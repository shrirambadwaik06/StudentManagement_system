package student_management_system.service;

import student_management_system.dto.AddStudentRequestDto;
import student_management_system.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();
    StudentDto getStudebtById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    void deleteStudentByid(Long id);
}
