package hu.cubix.cubixschool.mapper;

import hu.cubix.cubixschool.dto.TeacherDto;
import hu.cubix.cubixschool.model.Teacher;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    Teacher dtoToEntity(TeacherDto teacherDto);

    List<Teacher> dtosToEntities(List<TeacherDto> teacherDtos);

    @Named("summary")
    @Mapping(target = "coursesToTeach", ignore = true)
    TeacherDto entityToDto(Teacher teacher);

    @IterableMapping(qualifiedByName = "summary")
    List<TeacherDto> entitiesToDtos(List<Teacher> teachers);

}
