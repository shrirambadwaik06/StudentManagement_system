package student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student_management_system.entity.CourseEntity;

public interface CourceRepository extends JpaRepository<CourseEntity,Long> {
}
