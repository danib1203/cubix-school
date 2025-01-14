package hu.cubix.cubixschool.mapper;


import hu.cubix.cubixschool.model.Course;
import hu.cubix.cubixschool.model.Student;
import hu.cubix.cubixschool.model.Teacher;
import hu.webuni.cubixschool.api.model.CourseDto;
import hu.webuni.cubixschool.api.model.StudentDto;
import hu.webuni.cubixschool.api.model.TeacherDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course dtoToEntity(CourseDto courseDto);

    List<Course> dtoToEntity(List<CourseDto> courseDtos);

    CourseDto entityToDto(Course course);

    List<CourseDto> entitiesToDtos(List<Course> courses);

    @Named("summary")
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    CourseDto entitySummaryToDto(Course course);

    @IterableMapping(qualifiedByName = "summary")
    List<CourseDto> entitySummariesToDtos(List<Course> courses);

    @Mapping(target = "coursesToLearn", ignore = true)
    StudentDto studentToDto(Student student);

    @Mapping(target = "coursesToTeach", ignore = true)
    TeacherDto teacherToDto(Teacher teacher);
}
