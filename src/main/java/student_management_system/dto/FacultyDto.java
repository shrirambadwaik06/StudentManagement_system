package student_management_system.dto;

import lombok.Data;

@Data
public class FacultyDto {
    private Long id;
    private String name;
    private String email;
    private String ContactNumber;
    private String department;

    public FacultyDto(Long id, String name, String email, String ContactNumber,String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.ContactNumber = ContactNumber;
        this.department = department;
    }

    public FacultyDto() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContactNumber() {
        return ContactNumber;
    }
    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }
}