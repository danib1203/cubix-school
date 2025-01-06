package hu.cubix.cubixschool.service;

import hu.cubix.cubixschool.model.Course;
import hu.cubix.cubixschool.model.Student;
import hu.cubix.cubixschool.model.Teacher;
import hu.cubix.cubixschool.repository.CourseRepository;
import hu.cubix.cubixschool.repository.StudentRepository;
import hu.cubix.cubixschool.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class InitDbService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public void initDb() {

        Student student1 = studentRepository.save(Student.builder().id(0).name("Mark").birthDate(LocalDate.of(2000, 1, 1)).semester(2).build());
        Student student2 = studentRepository.save(Student.builder().id(0).name("Elza").birthDate(LocalDate.of(2005, 10, 21)).semester(1).build());
        Student student3 = studentRepository.save(Student.builder().id(0).name("Anna").birthDate(LocalDate.of(2002, 3, 15)).semester(4).build());
        Student student4 = studentRepository.save(Student.builder().id(0).name("Diák").semester(1).build());

        Teacher teacher1 = teacherRepository.save(Teacher.builder().id(0).name("Annamária").birthdate(LocalDate.of(1970, 3, 15)).build());
        Teacher teacher2 = teacherRepository.save(Teacher.builder().id(0).name("Janos").birthdate(LocalDate.of(1970, 3, 15)).build());
        Teacher teacher3 = teacherRepository.save(Teacher.builder().id(0).name("Tanár").build());


        Course maths = courseRepository.save(Course.builder().id(0).name("maths").build());
        Course history = courseRepository.save(Course.builder().id(0).name("history").build());
        Course emptyCourse = courseRepository.save(Course.builder().id(0).name("empty").build());

        student1.setCoursesToLearn(Set.of(maths, history));
        student2.setCoursesToLearn(Set.of(maths, history));
        student3.setCoursesToLearn(Set.of(history));
        teacher1.setCoursesToTeach(Set.of(history));
        teacher2.setCoursesToTeach(Set.of(maths, history));
        student4.setCoursesToLearn(Set.of(emptyCourse));
        teacher3.setCoursesToTeach(Set.of(emptyCourse));
    }

    public void clearDb() {
        studentRepository.deleteAll();
        teacherRepository.deleteAll();
        courseRepository.deleteAll();
    }
}
