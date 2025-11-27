package student_management_system.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student_management_system.dto.AddStudentRequestDto;
import student_management_system.dto.StudentDto;
import student_management_system.entity.Student;
import student_management_system.repository.StudentRepository;
import student_management_system.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public List<StudentDto> getAllStudents() {
        log.info("Fetching all students from the database");

        try {
            List<Student> students = studentRepository.findAll();
            log.debug("Number of student records fetched: {}", students.size());

            List<StudentDto> studentDtoList = students.stream()
                    .map(student -> new StudentDto(
                            student.getId(),
                            student.getName(),
                            student.getEmail(),
                            student.getCourse()
                    ))
                    .toList();

            log.debug("Number of StudentDto objects created: {}", studentDtoList.size());
            log.info("Successfully fetched all students");
            return studentDtoList;

        } catch (Exception e) {
            log.error("Unexpected error occurred while fetching all students", e);
            throw new RuntimeException("Failed to fetch students due to internal server error.");
        }
    }

    @Override
    public StudentDto getStudebtById(Long id) {
        log.info("Fetching student with id: {}", id);
        try {
            if(id == null || id <= 0){
                log.warn("Invalid student id provided: {}",id);
                throw new IllegalArgumentException("Invalid student id provided");
            }
            log.info("Finding student in the database with id: {}", id);
            Student student = studentRepository.findById(id).orElseThrow(()->{
                log.warn("No student found in DB with ID: {}",id);
                return new IllegalArgumentException("Student not found with id: " + id);
            });

            StudentDto studentDto = new StudentDto(student.getId(),
                    student.getName(),
                    student.getEmail(),
                    student.getCourse());
            return studentDto;
        }catch (IllegalArgumentException e) {
            log.error("Error fetching student with id {}: {}", id, e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error occurred while fetching student with id {}: {}", id, e.getMessage(), e);
            throw new RuntimeException("Failed to fetch student due to unexpected error.");
        }
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) throws IllegalAccessException {
        log.info("Request recieved a new student creation");

        try{
            //validate info
            if(addStudentRequestDto == null){
                log.warn("add student Dto is null . can not create student");
                throw new IllegalAccessException("Student data not be null ");

            }
            log.debug("AddStudentRequestDto received: {}", addStudentRequestDto);
            Student newStudent = new Student();
            newStudent.setName(addStudentRequestDto.getName());
            newStudent.setEmail(addStudentRequestDto.getEmail());
            newStudent.setCourse(addStudentRequestDto.getCourse());

            log.debug("Saving new student entity to database.....");

            Student savedStudent = studentRepository.save(newStudent);

            log.info("New student created with id: {}", savedStudent.getId());
            StudentDto studentDto = new StudentDto(savedStudent.getId(),
                    savedStudent.getName(),
                    savedStudent.getEmail(),
                    savedStudent.getCourse());
            log.debug("Returning StudentDto:  {}", studentDto);
            return studentDto;

        } catch (IllegalAccessException e) {
            log.error("Invalid student data provide while creating student:{}",e.getMessage(),e);
            throw e;
        } catch(Exception e){
            log.error("Unexpected error occurred while creating student: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to create new student due to unexpected error.");
        }

    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        log.info("Request received to update student with id: {}", id);
        try{
            if(id == null || id <= 0){
                log.warn("Invalid student id provided : {}",id);
                throw new IllegalArgumentException("Invalid student id provided");
            }
            if(addStudentRequestDto == null){
                log.warn("AddStudentRequestDto is null. cannot update student with id: {}",id);
                throw new IllegalArgumentException("Student data cannot be null");
            }
            log.debug("Incoming update request for ID: {} with data: {}", id,addStudentRequestDto);
            log.debug("Fetching student from the database wit h id:{}",id);
            Student existingStudent = studentRepository.findById(id).orElseThrow(() -> { log.warn("No student found in DB with ID: {}",id);
            return new IllegalArgumentException("Student not found with is:"+id);
            });
            // Update fields
            existingStudent.setName(addStudentRequestDto.getName());
            existingStudent.setEmail(addStudentRequestDto.getEmail());
            existingStudent.setCourse(addStudentRequestDto.getCourse());

            log.debug("Saving updated student entity to database for id:{}",id);
            Student upddatedStudent = studentRepository.save(existingStudent);
            log.info("Student updated successfully with id: {}",id);

            StudentDto studentDto = new StudentDto(upddatedStudent.getId(),
                    upddatedStudent.getName(),
                    upddatedStudent.getEmail(),
                    upddatedStudent.getCourse());
            log.debug("Returning updated student Dto :{}",studentDto);
            return studentDto;
        } catch (IllegalArgumentException e) {
            log.error("Error updating student eith id : {}",id,e.getMessage(),e);
            throw e;
        }
        catch(Exception e){
            log.error("Unexpected error occured while updating the student with ID:{}",id,e);
            throw new RuntimeException("Faliled to update student due to internal server error ..");
        }

}

    @Override
    public void deleteStudentByid(Long id) {
        log.info("Request receved to delete student with id:{}",id);
        try{
            if(id == null || id <= 0){
                log.warn("Invalid student id provided :{}",id);
                throw new IllegalArgumentException("Invalid student id provided");
            }
            log.info("Fetching student from database with id:{}",id);
            Student existingStudent = studentRepository.findById(id).orElseThrow(() -> {
                log.warn("No student found in DB with ID: {}",id);
                return new IllegalArgumentException("Student not found with id: " + id);
            });
            log.info("deleting student from database with id:{}",id);
            studentRepository.delete(existingStudent);
            log.info("Student deleted successfully with id:{}",id);
        }catch(IllegalArgumentException e){
            log.error("Error deleting student with id :{}",id,e);
            throw e;
        }
        catch(Exception e){
            log.error("Unexpected error occured while deleting the student with ID:{}",id,e);
            throw new RuntimeException("Failed to delete student due to internal server error.");
        }
    }
}
