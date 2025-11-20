package student_management_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student_management_system.dto.AddStudentRequestDto;
import student_management_system.dto.StudentDto;
import student_management_system.entity.Student;
import student_management_system.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class  StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public ResponseEntity<List<StudentDto>> getStudent(){
       // return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
     return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudebtById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDto> updateStudent( @PathVariable Long id, @RequestBody AddStudentRequestDto addStudentRequestDto){
        // Implementation for updating a student would go here
        return ResponseEntity.ok(studentService.updateStudent(id, addStudentRequestDto));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudentByid(id);
        return ResponseEntity.ok("Student deleted successfully with id: " + id);
    }

}
