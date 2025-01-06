package hu.cubix.cubixschool.dto;

import hu.cubix.cubixschool.model.Course;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter

public class StudentDto {


    private int id;
    private String name;
    private LocalDate birthDate;
    private int semester;
    private Set<Course> coursesToLearn;
}
