package student_management_system.dto;

import lombok.*;
import student_management_system.enums.AttendanceStatus;

import java.util.Date;

@Data
public class AttendanceRequestDto {

    private Long studentId;   // ID of the student

    private Long courseId;    // ID of the course

    private Long facultyId;   // ID of the faculty

    private Date date;        // Date of attendance

    private AttendanceStatus attendanceStatus;  // PRESENT / ABSENT / LEAVE etc.

    private Integer marks;// Marks (if any)

    public AttendanceRequestDto(Long studentId, Long courseId, Long facultyId, Date date, AttendanceStatus attendanceStatus, Integer marks) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.facultyId = facultyId;
        this.date = date;
        this.attendanceStatus = attendanceStatus;
        this.marks = marks;
    }

    public AttendanceRequestDto(){}

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
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
