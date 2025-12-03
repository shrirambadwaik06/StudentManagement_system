package student_management_system.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import student_management_system.dto.AttendanceDto;
import student_management_system.dto.AttendanceRequestDto;
import student_management_system.service.AttendanceService;

@RestController
@RequestMapping("api")
public class AttendanceController {

    private final AttendanceService attendanceService;
    private static final Logger log = LoggerFactory.getLogger(AttendanceController.class);

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/attendance")
    public ResponseEntity<AttendanceDto> createAttendance(@Valid @RequestBody AttendanceRequestDto dto){
         log.info("Create AttendaceAPi Called :");
        return ResponseEntity.ok(attendanceService.createAttendace(dto));
    }
}
