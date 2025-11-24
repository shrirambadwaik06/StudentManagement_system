package student_management_system.service;

import student_management_system.dto.AddCourseRequest;
import student_management_system.dto.CourseDto;

import java.util.List;

public interface CourseService {

     CourseDto CreateCourse(AddCourseRequest addCourseRequest);

    List<CourseDto> getAllCourses();

    CourseDto getCourseById(Long id);

    String deleteCourseById(Long id);

    CourseDto updateCourseById(Long id, AddCourseRequest addCourseRequest);
}
