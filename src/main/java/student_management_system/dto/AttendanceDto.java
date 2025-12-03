package student_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import student_management_system.enums.AttendanceStatus;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDto {

    private Long attendanceId;

    private Long studentId;  // Reference to Student entity

    private Long courseId;   // Reference to Course entity

    private Long facultyId;  // Reference to Faculty entity

    private Date date;

    private AttendanceStatus attendanceStatus;

    private Integer marks;
}
