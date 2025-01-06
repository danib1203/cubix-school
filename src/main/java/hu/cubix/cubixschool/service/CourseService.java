package hu.cubix.cubixschool.service;

import com.google.common.collect.Lists;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import hu.cubix.cubixschool.model.Course;
import hu.cubix.cubixschool.model.QCourse;
import hu.cubix.cubixschool.model.Student;
import hu.cubix.cubixschool.model.Teacher;
import hu.cubix.cubixschool.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Transactional
    public List<Course> findCoursesByExample(
            Course exampleCourse,
            Optional<Integer> semesterFrom,
            Optional<Integer> semesterTo,
            Pageable pageable) {
        int id = exampleCourse.getId();
        String courseName = exampleCourse.getName();

        String teacherName = Optional.ofNullable(exampleCourse.getTeachers())
                .flatMap(teachers -> teachers.stream().findFirst().map(Teacher::getName))
                .orElse("");
        int studentId = Optional.ofNullable(exampleCourse.getStudents())
                .flatMap(students -> students.stream().findFirst().map(Student::getId))
                .orElse(0);

        int from = semesterFrom.orElse(0);
        int to = semesterTo.orElse(0);
        ArrayList<Predicate> predicates = new ArrayList<>();
        QCourse course = QCourse.course;

        if (id > 0)
            predicates.add(course.id.eq(id));

        if (StringUtils.hasText(courseName))
            predicates.add(course.name.startsWithIgnoreCase(courseName));

        if (StringUtils.hasText(teacherName))
            predicates.add(course.teachers.any().name.startsWithIgnoreCase(teacherName));

        if (studentId > 0)
            predicates.add(course.students.any().id.eq(id));

        if (from > 0 && to > 0)
            predicates.add(course.students.any().semester.between(from, to));

        if (predicates.isEmpty())
            return null;
        else {
            //  return Lists.newArrayList(courseRepository.findAll(ExpressionUtils.allOf(predicates)));
            List<Course> courses = Lists.newArrayList(courseRepository.findAll(ExpressionUtils.allOf(predicates), pageable));
            List<Integer> courseIds = courses.stream().map(Course::getId).toList();
            courses = courseRepository.findByIdWithStudents(courseIds);
            courses = courseRepository.findByIdAllWithTeachers(courseIds);

            return courses;
        }
    }

    public Optional<Course> findById(int id) {
        return courseRepository.findById(id);
    }

    @Transactional
    public List<Course> findAllWithRelationships(/*Pageable pageable*/) {
        List<Course> courses = courseRepository.findAll();
        courses = courseRepository.findAllWithStudents();
        courses = courseRepository.findAllWithTeachers();
        return courses;
    }


}


