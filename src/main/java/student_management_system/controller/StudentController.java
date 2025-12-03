package student_management_system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.sql.ast.tree.expression.Summarization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student_management_system.dto.AddStudentRequestDto;
import student_management_system.dto.StudentDto;
import student_management_system.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Student API", description = "Operation for the study module ")
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Get all students
    @GetMapping("/student")
    @Operation(summary = "Get student by ID", description ="return a student  for the given ID")
    public ResponseEntity<List<StudentDto>> getStudent() {
        log.info("API Called: GET /student");                     // API call info
        List<StudentDto> students = studentService.getAllStudents();
        log.info("Returning {} students", students.size());       // Response info
        return ResponseEntity.ok(students);
    }

    // Get student by ID
    @GetMapping("/students/{id}")
    @Operation(summary = "Get Student by Id ",description = "get stydent from id ")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        log.info("API Called: GET /students/{}", id);             // API call
        try {
            StudentDto student = studentService.getStudebtById(id);
            log.info("Student found with id {}", id);
            return ResponseEntity.ok(student);
        } catch (Exception ex) {
            log.error("Error fetching student with id {}: {}", id, ex.getMessage(), ex);
            throw ex;
        }
    }

    // Create a new student
    @PostMapping("/students")
    @Operation(summary = "Create a new student" , description = "create a student")
    public ResponseEntity<StudentDto> createStudent(@RequestBody AddStudentRequestDto addStudentRequestDto) throws IllegalAccessException {
        log.info("API Called: POST /students");                   // API call info
        log.debug("Request Body: {}", addStudentRequestDto);      // Detailed input
        try {
            StudentDto createdStudent = studentService.createNewStudent(addStudentRequestDto);
            log.info("Student created successfully with id {}", createdStudent.getStudentId());
            return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
        } catch (Exception ex) {
            log.error("Error creating student: {}", ex.getMessage(), ex);
            throw ex;
        }
    }

    // Update a student
    @PutMapping("/students/{id}")
    @Operation(summary = "Update a student by using id ",description = "update student")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,
                                                    @RequestBody AddStudentRequestDto addStudentRequestDto) {
        log.info("API Called: PUT /students/{}", id);
        log.debug("Request Body: {}", addStudentRequestDto);
        try {
            StudentDto updatedStudent = studentService.updateStudent(id, addStudentRequestDto);
            log.info("Student updated successfully with id {}", id);
            return ResponseEntity.ok(updatedStudent);
        } catch (Exception ex) {
            log.error("Error updating student with id {}: {}", id, ex.getMessage(), ex);
            throw ex;
        }
    }

    // Delete a student
    @DeleteMapping("/students/{id}")
    @Operation(summary = "Delete Student by using Id " ,description = "Delete student using Id")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        log.info("API Called: DELETE /students/{}", id);
        try {
            studentService.deleteStudentByid(id);
            log.info("Student deleted successfully with id {}", id);
            return ResponseEntity.ok("Student deleted successfully with id: " + id);
        } catch (Exception ex) {
            log.error("Error deleting student with id {}: {}", id, ex.getMessage(), ex);
            throw ex;
        }
    }
}
