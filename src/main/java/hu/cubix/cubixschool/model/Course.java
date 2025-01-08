package hu.cubix.cubixschool.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@ToString
@Audited
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include()
    private int id;

    private String name;

    @ManyToMany(mappedBy = "coursesToLearn")
    private Set<Student> students;

    @ManyToMany(mappedBy = "coursesToTeach")
    private Set<Teacher> teachers;
}
