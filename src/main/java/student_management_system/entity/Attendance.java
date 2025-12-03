package student_management_system.entity;

import jakarta.persistence.*;
import student_management_system.entity.CourseEntity;
import student_management_system.entity.Faculty;
import student_management_system.entity.Student;
import student_management_system.enums.AttendanceStatus;

import java.util.Date;

@Entity
@Table(name = "attendance_table")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;

    @ManyToOne
    @JoinColumn(name ="student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name ="course_id", nullable = false)
    private CourseEntity course;

    @ManyToOne
    @JoinColumn(name ="faculty_id", nullable = false)
    private Faculty faculty;

    private Date date;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus attendanceStatus;

    private Integer marks;

    public Attendance(Long attendanceId, Student student, CourseEntity course, Faculty faculty, Date date, AttendanceStatus attendanceStatus, Integer marks) {
        this.attendanceId = attendanceId;
        this.student = student;
        this.course = course;
        this.faculty = faculty;
        this.date = date;
        this.attendanceStatus = attendanceStatus;
        this.marks = marks;
    }

    public Attendance(){

    }

    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AttendanceStatus getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(AttendanceStatus attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }
}
