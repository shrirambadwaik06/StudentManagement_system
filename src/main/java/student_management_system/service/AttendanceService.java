package student_management_system.service;

import jakarta.validation.Valid;
import student_management_system.dto.AttendanceDto;
import student_management_system.dto.AttendanceRequestDto;

public interface AttendanceService {

    AttendanceDto createAttendace(@Valid AttendanceRequestDto dto);
}
