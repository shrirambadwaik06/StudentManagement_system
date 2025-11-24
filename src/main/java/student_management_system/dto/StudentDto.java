package student_management_system.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private String course;

    public StudentDto(Long id, String name, String email, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course= course;
    }
}
