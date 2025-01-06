package hu.cubix.cubixschool.repository;

import hu.cubix.cubixschool.model.Course;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer>,
        JpaSpecificationExecutor<Course>,
        QuerydslPredicateExecutor<Course> {


    @EntityGraph(attributePaths = {"students"})
    @Query("SELECT a FROM Course a")
    List<Course> findAllWithStudents();

    @EntityGraph(attributePaths = {"teachers"})
    @Query("SELECT a FROM Course a")
    List<Course> findAllWithTeachers();

    @EntityGraph(attributePaths = {"students"})
    @Query("SELECT a FROM Course a where a.id in :courseIds")
    List<Course> findByIdWithStudents(List<Integer> courseIds);

    @EntityGraph(attributePaths = {"teachers"})
    @Query("SELECT a FROM Course a where a.id in :courseIds")
    List<Course> findByIdAllWithTeachers(List<Integer> courseIds);
}
