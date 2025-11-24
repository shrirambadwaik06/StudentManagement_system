package student_management_system.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class CourseDto {
    private Long id;
    private String courseName;
    private String courseDescription;
    private double fees;

    public CourseDto(){

    }
    public CourseDto(Long id, String courseName, String courseDescription, double fees) {
        this.id = id;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.fees = fees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }
}
