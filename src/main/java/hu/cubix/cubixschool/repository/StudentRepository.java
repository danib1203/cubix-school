package hu.cubix.cubixschool.repository;

import hu.cubix.cubixschool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentByCentralIdentification(int centralIdentification);
}
