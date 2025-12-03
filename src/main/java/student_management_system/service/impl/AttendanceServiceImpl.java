package student_management_system.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import student_management_system.dto.AttendanceDto;
import student_management_system.dto.AttendanceRequestDto;
import student_management_system.entity.Attendance;
import student_management_system.entity.CourseEntity;
import student_management_system.entity.Faculty;
import student_management_system.entity.Student;
import student_management_system.repository.AttendaceStatusRepository;
import student_management_system.repository.CourceRepository;
import student_management_system.repository.FacultyRepository;
import student_management_system.repository.StudentRepository;
import student_management_system.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private  final ModelMapper modelMapper;
    private static final Logger log = LoggerFactory.getLogger(AttendanceServiceImpl.class);

    private final AttendaceStatusRepository attendaceStatusRepository;
    private final StudentRepository studentRepository;
    private final CourceRepository courceRepository;
    private final FacultyRepository facultyRepository;

    public AttendanceServiceImpl(ModelMapper modelMapper, AttendaceStatusRepository attendaceStatusRepository, StudentRepository studentRepository, CourceRepository courceRepository, FacultyRepository facultyRepository) {
        this.modelMapper = modelMapper;
        this.attendaceStatusRepository = attendaceStatusRepository;
        this.studentRepository = studentRepository;
        this.courceRepository = courceRepository;
        this.facultyRepository = facultyRepository;
    }


    @Override
    public AttendanceDto createAttendace(AttendanceRequestDto dto) {
    try {
        log.info("Creating attendance for Student ID: {}, Course ID: {}, Faculty ID: {}",
                dto.getStudentId(), dto.getCourseId(), dto.getFacultyId());
        Student student = studentRepository.findById(dto.getStudentId()).orElseThrow(() -> new IllegalArgumentException("Student not found with ID"));
        CourseEntity course = courceRepository.findById(dto.getCourseId()).orElseThrow(() -> new IllegalArgumentException("Course Not found with Id:"));
        Faculty faculty = facultyRepository.findById(dto.getFacultyId()).orElseThrow(() -> new IllegalArgumentException("Not found with Id"));

        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setCourse(course);
        attendance.setFaculty(faculty);
        attendance.setDate(dto.getDate());
        attendance.setAttendanceStatus(dto.getAttendanceStatus());
        attendance.setMarks(dto.getMarks());

        Attendance savedAttendance = attendaceStatusRepository.save(attendance);

        AttendanceDto attendanceDto = new AttendanceDto();
        attendanceDto.setAttendanceId(savedAttendance.getAttendanceId());
        attendanceDto.setStudentId(savedAttendance.getStudent().getId());
        attendanceDto.setCourseId(savedAttendance.getCourse().getId());
        attendanceDto.setFacultyId(savedAttendance.getFaculty().getId());
        attendanceDto.setDate(savedAttendance.getDate());
        attendanceDto.setAttendanceStatus(savedAttendance.getAttendanceStatus());
        attendanceDto.setMarks(savedAttendance.getMarks());
      log.info("Attendance Create Successfully for Student ID : {}",attendanceDto.getStudentId());
        return attendanceDto;
    }
    catch (IllegalArgumentException ex){
       log.error("Error creating attendance : {}",ex.getMessage());
       throw ex;
    }
    catch (Exception e){
        log.error("Failed to create Attendance :",e);
        throw new RuntimeException("Failed to create exception :{}",e);
    }
    }
}
