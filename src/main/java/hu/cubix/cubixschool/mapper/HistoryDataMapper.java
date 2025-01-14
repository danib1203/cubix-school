package hu.cubix.cubixschool.mapper;

import hu.cubix.cubixschool.model.Course;
import hu.cubix.cubixschool.model.HistoryData;
import hu.cubix.cubixschool.model.Student;
import hu.cubix.cubixschool.model.Teacher;
import hu.webuni.cubixschool.api.model.HistoryDataCourseDto;

import hu.webuni.cubixschool.api.model.StudentDto;
import hu.webuni.cubixschool.api.model.TeacherDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HistoryDataMapper {

     @Mapping(target = "revisionType", source = "revType")
    HistoryDataCourseDto courseHistoryDataToDto(HistoryData<Course> hd);


    @Mapping(target = "coursesToLearn", ignore = true)
    StudentDto studentToDto(Student student);

    @Mapping(target = "coursesToTeach", ignore = true)
    TeacherDto teacherToDto(Teacher teacher);

}
