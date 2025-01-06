package hu.cubix.cubixschool.mapper;

import hu.cubix.cubixschool.dto.StudentDto;
import hu.cubix.cubixschool.model.Student;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student dtoToEntity(StudentDto studentDto);

    List<Student> dtosToEntities(List<StudentDto> studentDtos);

    @Named("summary")
    @Mapping(target = "coursesToLearn", ignore = true)
    StudentDto entityToDto(Student student);

    @IterableMapping(qualifiedByName = "summary")
    List<StudentDto> entitiesToDtos(List<Student> students);

}
