package student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student_management_system.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {
}
