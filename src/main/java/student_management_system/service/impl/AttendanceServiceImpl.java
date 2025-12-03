package student_management_system.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import student_management_system.controller.AttendanceController;
import student_management_system.dto.AttendanceDto;
import student_management_system.dto.AttendanceRequestDto;
import student_management_system.entity.CourseEntity;
import student_management_system.entity.Faculty;
import student_management_system.entity.Student;
import student_management_system.enums.AttendanceStatus;
import student_management_system.repository.AttendaceStatusRepository;
import student_management_system.repository.CourceRepository;
import student_management_system.repository.FacultyRepository;
import student_management_system.repository.StudentRepository;
import student_management_system.service.AttendanceService;

import java.util.Date;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private static final Logger log = LoggerFactory.getLogger(AttendanceServiceImpl.class);

    private final AttendaceStatusRepository attendaceStatusRepository;
    private final StudentRepository studentRepository;
    private final CourceRepository courceRepository;
    private final FacultyRepository facultyRepository;

    public AttendanceServiceImpl(AttendaceStatusRepository attendaceStatusRepository, StudentRepository studentRepository, CourceRepository courceRepository, FacultyRepository facultyRepository) {
        this.attendaceStatusRepository = attendaceStatusRepository;
        this.studentRepository = studentRepository;
        this.courceRepository = courceRepository;
        this.facultyRepository = facultyRepository;
    }


   /* private Long studentId;   // ID of the student
    private Long courseId;    // ID of the course
    private Long facultyId;   // ID of the faculty
    private Date date;        // Date of attendance
    private AttendanceStatus attendanceStatus;  // PRESENT / ABSENT / LEAVE etc.
*/
    private Integer marks;
    @Override
    public AttendanceDto createAttendace(AttendanceRequestDto dto) {

        Student student = studentRepository.findById(dto.getStudentId()).orElseThrow(() -> new IllegalArgumentException("Student not found with ID"));
        CourseEntity course = courceRepository.findById(dto.getCourseId()).orElseThrow(() -> new IllegalArgumentException("Course Not found with Id:"));
        Faculty faculty = facultyRepository.findById(dto.getFacultyId()).orElseThrow(()-> new IllegalArgumentException("Not found with Id"));




        return null;
    }
}
