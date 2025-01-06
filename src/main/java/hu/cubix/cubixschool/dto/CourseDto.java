package hu.cubix.cubixschool.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CourseDto {

    private int id;
    private String name;
    private Set<StudentDto> students;
    private Set<TeacherDto> teachers;
}
