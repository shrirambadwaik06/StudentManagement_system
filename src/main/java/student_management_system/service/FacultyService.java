package student_management_system.service;

import org.springframework.http.ResponseEntity;
import student_management_system.dto.AddFacultyRequestDto;
import student_management_system.dto.FacultyDto;

import java.util.List;

public interface FacultyService {

    FacultyDto createFaculty(AddFacultyRequestDto addFacultyRequestDto);

    FacultyDto getFacultyById(Long id);

    List<FacultyDto> getAllFaculties();

    FacultyDto updateFaculty(Long id, AddFacultyRequestDto addFacultyRequestDto);

    Void deleteFacultyById(Long id);
}
