package student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student_management_system.entity.Attendance;

public interface AttendaceStatusRepository extends JpaRepository<Attendance,Long> {
}
