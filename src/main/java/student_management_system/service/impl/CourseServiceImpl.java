package student_management_system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student_management_system.dto.AddCourseRequest;
import student_management_system.dto.CourseDto;
import student_management_system.entity.CourseEntity;
import student_management_system.service.CourseService;
import student_management_system.repository.CourceRepository;

import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private final CourceRepository courseRepository;

    public CourseServiceImpl(CourceRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDto CreateCourse(AddCourseRequest addCourseRequest) {
        // Create new CourseEntity from AddCourseRequest
        CourseEntity newCourse = new CourseEntity();
        // Set properties
        newCourse.setCourseName(addCourseRequest.getCourseName());
        newCourse.setFees(addCourseRequest.getFees());
        newCourse.setCourseDescription(addCourseRequest.getCourseDescription());
       // Save entity to repository
        CourseEntity courseEntity = courseRepository.save(newCourse);
        // Convert saved entity to CourseDto
        CourseDto courseDto = new CourseDto();
        courseDto.setId(courseEntity.getId());
        courseDto.setCourseName(courseEntity.getCourseName());
        courseDto.setCourseDescription(courseEntity.getCourseDescription());
        courseDto.setFees(courseEntity.getFees());
        // Return the CourseDto
        return courseDto;

    }

    @Override
    public List<CourseDto> getAllCourses() {
        // Fetch all CourseEntity from repository into a list in CourseEntity object
        List<CourseEntity> courses = courseRepository.findAll();
        // Convert list of CourseEntity to list of CourseDto
        List<CourseDto> courseDto = courses.stream().map(course -> new CourseDto(course.getId(),
                        course.getCourseName(),
                        course.getCourseDescription(),
                        course.getFees()))
                .toList();
        // Return the list of CourseDto
        return courseDto;
    }

    @Override
    public CourseDto getCourseById(Long id) {
        CourseEntity course = courseRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Course not found with id: " + id));
        CourseDto courseDto = new CourseDto(course.getId(),
                course.getCourseName(),
                course.getCourseDescription(),
                course.getFees());
        return courseDto;
    }

    @Override
    public String deleteCourseById(Long id) {
        CourseEntity courseEntity = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        courseRepository.delete(courseEntity);
        return "Course deleted successfully with id: " + id;
    }

    @Override
    public CourseDto updateCourseById(Long id, AddCourseRequest addCourseRequest) {
        // Find existing CourseEntity by id if not found throw exception
        CourseEntity course = courseRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Course not found with id: " + id));
        // Update properties from AddCourseRequest object
        course.setCourseName(addCourseRequest.getCourseName());
        course.setCourseDescription(addCourseRequest.getCourseDescription());
        course.setFees(addCourseRequest.getFees());
        // Save updated entity to repository
        CourseEntity updatedCourse = courseRepository.save(course);
        // Convert updated entity to CourseDto
        CourseDto courseDto = new CourseDto(updatedCourse.getId(),
                updatedCourse.getCourseName(),
                updatedCourse.getCourseDescription(),
                updatedCourse.getFees());
        return courseDto;
    }
}
