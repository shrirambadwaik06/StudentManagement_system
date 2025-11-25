package student_management_system.dto;

import lombok.Data;

@Data
public class AddFacultyRequestDto {

    private String name;
    private String email;
    private String ContactNumber;
    private String department;

    public AddFacultyRequestDto() {
    }

    public AddFacultyRequestDto(String name, String email, String contactNumber, String department) {
        this.name = name;
        this.email = email;
        this.ContactNumber = contactNumber;
        this.department = department;
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

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
