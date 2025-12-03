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
public class AttendanceRequestDto {

    private Long studentId;   // ID of the student

    private Long courseId;    // ID of the course

    private Long facultyId;   // ID of the faculty

    private Date date;        // Date of attendance

    private AttendanceStatus attendanceStatus;  // PRESENT / ABSENT / LEAVE etc.

    private Integer marks;    // Marks (if any)
}
