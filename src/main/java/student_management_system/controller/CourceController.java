package student_management_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student_management_system.dto.AddCourseRequest;
import student_management_system.dto.CourseDto;
import student_management_system.service.CourseService;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api")
public class CourceController {

    @Autowired
    private final CourseService courseService;

    public CourceController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/Courses")
    public ResponseEntity<CourseDto> CreateCourse(@RequestBody AddCourseRequest addCourseRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.CreateCourse(addCourseRequest));
    }

    @GetMapping("/Courses")
    public ResponseEntity<List<CourseDto>> getAllCourses(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/Courses/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @DeleteMapping("/Courses/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.deleteCourseById(id));

    }

    public ResponseEntity<CourseDto> updateCourdeByID(@PathVariable Long id,@RequestBody AddCourseRequest addCourseRequest){
        return ResponseEntity.ok(courseService.updateCourseById(id,addCourseRequest));
    }

}
