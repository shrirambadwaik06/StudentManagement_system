package student_management_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import student_management_system.StudentManagementSystem1Application;
import student_management_system.entity.student;
@Repository
public interface studentRepository extends JpaRepository<student, Long>{
	Optional<student> findByEmail(String email);
}
