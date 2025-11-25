package student_management_system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import student_management_system.dto.AddFacultyRequestDto;
import student_management_system.dto.FacultyDto;
import student_management_system.entity.Faculty;
import student_management_system.repository.FacultyRepository;
import student_management_system.service.FacultyService;

import java.util.List;

@Service
public class FacullyServiceImpl implements FacultyService {
    @Autowired
    private final FacultyRepository facultyRepository;

    public FacullyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public FacultyDto createFaculty(AddFacultyRequestDto addFacultyRequestDto) {
        Faculty faculty = new Faculty();
        faculty.setName(addFacultyRequestDto.getName());
        faculty.setEmail(addFacultyRequestDto.getEmail());
        faculty.setContactNumber(addFacultyRequestDto.getContactNumber());
        faculty.setDepartment(addFacultyRequestDto.getDepartment());


        // Here you would typically save the faculty entity to the database
        // and retrieve the generated ID. For this example, we'll skip that part.
        Faculty savedFaculty = facultyRepository.save(faculty); // Assume this is the saved entity with an ID.

        // Convert saved entity to FacultyDto
        FacultyDto facultyDto = new FacultyDto();
        facultyDto.setId(savedFaculty.getId());
        facultyDto.setName(savedFaculty.getName());
        facultyDto.setEmail(savedFaculty.getEmail());
        facultyDto.setContactNumber(savedFaculty.getContactNumber());
        facultyDto.setDepartment(savedFaculty.getDepartment());
        return facultyDto;
    }

    @Override
    public FacultyDto getFacultyById(Long id) {
        Faculty faculty = facultyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Faculty not found with ID :" + id));
        FacultyDto facultyDto = new FacultyDto(faculty.getId(),
                faculty.getName(),
                faculty.getEmail(),
                faculty.getContactNumber(),
                faculty.getDepartment());
        return facultyDto;

    }

    @Override
    public List<FacultyDto> getAllFaculties() {
        List<Faculty> faculty = facultyRepository.findAll();
        List<FacultyDto> facultyDtoList = faculty.stream()
                .map(f -> new FacultyDto(f.getId(),
                        f.getName(),
                        f.getEmail(),
                        f.getContactNumber(),
                        f.getDepartment()))
                .toList();
        return facultyDtoList;
    }

    @Override
    public FacultyDto updateFaculty(Long id, AddFacultyRequestDto addFacultyRequestDto) {
        Faculty existingFaculty = facultyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Faculty not found with id: " + id));
        existingFaculty.setName(addFacultyRequestDto.getName());
        existingFaculty.setEmail(addFacultyRequestDto.getEmail());
        existingFaculty.setContactNumber(addFacultyRequestDto.getContactNumber());
        existingFaculty.setDepartment(addFacultyRequestDto.getDepartment());

        Faculty updatedFaculty = facultyRepository.save(existingFaculty);
        FacultyDto facultyDto = new FacultyDto(updatedFaculty.getId(),
                updatedFaculty.getName(),
                updatedFaculty.getEmail(),
                updatedFaculty.getContactNumber(),
                updatedFaculty.getDepartment());

        return facultyDto;
    }

    @Override
    public Void deleteFacultyById(Long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faculty not found with id: " + id));
        facultyRepository.delete(faculty);
        return null;

    }


}

