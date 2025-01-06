package hu.cubix.cubixschool.repository;

import hu.cubix.cubixschool.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
