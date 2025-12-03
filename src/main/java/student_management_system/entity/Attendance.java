package student_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import student_management_system.enums.AttendanceStatus;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Attendace_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;

    @ManyToOne
    @JoinColumn(name ="Student_id",nullable = false)
    private Student Student;
    @ManyToOne
    @JoinColumn(name ="Course_id", nullable = false)
    private CourseEntity course;

    @ManyToOne
    @JoinColumn(name ="Faculty_id",nullable = false)
    private Faculty faculty;

    private Date date;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus attendanceStatus;

    private Integer marks;
}
