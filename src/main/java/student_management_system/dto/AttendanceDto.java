package student_management_system.dto;

import lombok.*;
import student_management_system.enums.AttendanceStatus;

import java.util.Date;

@Data
public class AttendanceDto {

    private Long attendanceId;

    private Long studentId;  // Reference to Student entity

    private Long courseId;   // Reference to Course entity

    private Long facultyId;  // Reference to Faculty entity

    private Date date;

    private AttendanceStatus attendanceStatus;

    private Integer marks;

    public AttendanceDto(){

    }
    public AttendanceDto(Long attendanceId, Long studentId, Long courseId, Long facultyId, AttendanceStatus attendanceStatus, Date date, Integer marks) {
        this.attendanceId = attendanceId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.facultyId = facultyId;
        this.attendanceStatus = attendanceStatus;
        this.date = date;
        this.marks = marks;
    }

    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }

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
