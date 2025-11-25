package student_management_system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student_management_system.dto.AddFacultyRequestDto;
import student_management_system.dto.FacultyDto;
import student_management_system.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FacultyContrller {

    private final FacultyService facultyService;

    public FacultyContrller(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("/faculties")
    public ResponseEntity<FacultyDto> createFaculty(@RequestBody AddFacultyRequestDto addFacultyRequestDto) {
       return ResponseEntity.ok(facultyService.createFaculty(addFacultyRequestDto));
    }

    @GetMapping("/faculties/{Id}")
    public ResponseEntity<FacultyDto> getFacultyById(@PathVariable Long Id) {
        return ResponseEntity.ok(facultyService.getFacultyById(Id));
    }

    @GetMapping("/faculties")
    public ResponseEntity<List<FacultyDto>> getAllFaculties(){
        return ResponseEntity.ok(facultyService.getAllFaculties());
    }

    @PutMapping("/faculties/{id}")
    public ResponseEntity<FacultyDto> updateFaculty(@PathVariable Long id, @RequestBody AddFacultyRequestDto addFacultyRequestDto) {
        // Implementation for updating a faculty would go here
        return ResponseEntity.ok(facultyService.updateFaculty(id, addFacultyRequestDto));
    }

    public ResponseEntity<String> deleteFacultyByid(@PathVariable Long id){
        facultyService.deleteFacultyById(id);
        return ResponseEntity.ok("Faculty deleted successfully with id: " + id);
    }
}
