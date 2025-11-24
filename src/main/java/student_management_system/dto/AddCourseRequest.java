package student_management_system.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class AddCourseRequest {

    private String courseName;
    private String courseDescription;
    private double fees;

    public AddCourseRequest() {
    }

    public AddCourseRequest(String courseName, String courseDescription, double fees) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.fees = fees;
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
