package student_management_system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student_management_system.dto.AddStudentRequestDto;
import student_management_system.dto.StudentDto;
import student_management_system.entity.Student;
import student_management_system.repository.StudentRepository;
import student_management_system.service.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtoList = students.stream()
                        .map(student -> new StudentDto(student.getId(),
                                student.getName(),
                                student.getEmail(),
                                student.getCourse()))
                        .toList();
        return studentDtoList;
      }

    @Override
    public StudentDto getStudebtById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
        StudentDto studentDto = new StudentDto(student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse());
        return studentDto;
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = new Student();
        newStudent.setName(addStudentRequestDto.getName());
        newStudent.setEmail(addStudentRequestDto.getEmail());
        newStudent.setCourse(addStudentRequestDto.getCourse());
        Student student = studentRepository.save(newStudent);// <-- here we can add only entity object

        StudentDto studentDto = new StudentDto(student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse());
        return studentDto;
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("student not found with id:" + id));
        existingStudent.setName(addStudentRequestDto.getName());
        existingStudent.setEmail(addStudentRequestDto.getEmail());
        existingStudent.setCourse(addStudentRequestDto.getCourse());
        Student updatedStudent = studentRepository.save(existingStudent);

        StudentDto studentDto = new StudentDto(updatedStudent.getId(),
                updatedStudent.getName(),updatedStudent.getEmail(),updatedStudent.getCourse());

        return studentDto;

    }

    @Override
    public void deleteStudentByid(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        studentRepository.delete(student);
    }


}
