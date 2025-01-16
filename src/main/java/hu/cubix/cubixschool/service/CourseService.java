package hu.cubix.cubixschool.service;

import com.google.common.collect.Lists;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import hu.cubix.cubixschool.model.*;
import hu.cubix.cubixschool.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    @PersistenceContext
    private EntityManager em;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Transactional
    @Cacheable("coursesByExample")
    public List<Course> findCoursesByExample(Course exampleCourse, Optional<Integer> semesterFrom, Optional<Integer> semesterTo, Pageable pageable) {
        int id = exampleCourse.getId();
        String courseName = exampleCourse.getName();

        String teacherName = Optional.ofNullable(exampleCourse.getTeachers()).flatMap(teachers -> teachers.stream().findFirst().map(Teacher::getName)).orElse("");
        int studentId = Optional.ofNullable(exampleCourse.getStudents()).flatMap(students -> students.stream().findFirst().map(Student::getId)).orElse(0);

        int from = semesterFrom.orElse(0);
        int to = semesterTo.orElse(0);
        ArrayList<Predicate> predicates = new ArrayList<>();
        QCourse course = QCourse.course;

        if (id > 0) predicates.add(course.id.eq(id));

        if (StringUtils.hasText(courseName)) predicates.add(course.name.startsWithIgnoreCase(courseName));

        if (StringUtils.hasText(teacherName)) predicates.add(course.teachers.any().name.startsWithIgnoreCase(teacherName));

        if (studentId > 0) predicates.add(course.students.any().id.eq(id));

        if (from > 0 && to > 0) predicates.add(course.students.any().semester.between(from, to));

        if (predicates.isEmpty()) return null;
        else {
            //  return Lists.newArrayList(courseRepository.findAll(ExpressionUtils.allOf(predicates)));
            List<Course> courses = Lists.newArrayList(courseRepository.findAll(ExpressionUtils.allOf(predicates), pageable));
            List<Integer> courseIds = courses.stream().map(Course::getId).toList();
            courses = courseRepository.findByIdWithStudents(courseIds);
            courses = courseRepository.findByIdAllWithTeachers(courseIds, pageable.getSort());

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

    @Transactional
    @SuppressWarnings({"unchecked"})
    public List<HistoryData<Course>> getCourseHistory(long id) {
        return AuditReaderFactory.get(em).createQuery()
                .forRevisionsOfEntity(Course.class, false, true)
                .add(AuditEntity.property("id").eq(id))
                .getResultList().stream().map(o -> {
                    Object[] objArray = (Object[]) o;
                    DefaultRevisionEntity defaultRevisionEntity = (DefaultRevisionEntity) objArray[1];
                    Course course = (Course) objArray[0];
                    course.getName().toString();
                    course.getTeachers().size();
                    course.getStudents().size();
                    return new HistoryData<Course>(course,
                            (RevisionType) objArray[2],
                            defaultRevisionEntity.getId(),
                            defaultRevisionEntity.getRevisionDate());
                }).toList();
    }

    @Transactional
    @SuppressWarnings(value = "unchecked")
    public Course getCourseAtGivenRevision(int courseId, LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();

        long startOfDay = localDate.atStartOfDay(zoneId).toInstant().toEpochMilli();
        long endOfDay = localDate.atTime(23, 59, 59, 999_999_999).atZone(zoneId).toInstant().toEpochMilli();

        AuditReader auditReader = AuditReaderFactory.get(em);
        List<Object[]> results = auditReader.createQuery()
                .forRevisionsOfEntity(Course.class, false, true)
                .add(AuditEntity.id().eq(courseId))
                .add(AuditEntity.revisionProperty("timestamp").ge(startOfDay))
                .add(AuditEntity.revisionProperty("timestamp").le(endOfDay))
                .addOrder(AuditEntity.revisionNumber().desc())
                .setMaxResults(1)
                .getResultList();

        try {
            Course course = (Course) results.get(0)[0];
            course.getName().toString();
            course.getTeachers().size();
            course.getStudents().size();
            return course;
        } catch (IndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Transactional
    public OptionalDouble getAverageSemesterByCourse(int courseId) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Course course = courseRepository.findById(courseId).orElse(null);
        if (course == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        Set<Student> students = course.getStudents();

        return Arrays.stream(students.stream().mapToInt(Student::getSemester).toArray()).average();
    }

}




