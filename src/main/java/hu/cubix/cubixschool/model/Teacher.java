package hu.cubix.cubixschool.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@ToString
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include()
    private int id;

    private String name;
    private LocalDate birthdate;

    @ManyToMany
    private Set<Course> coursesToTeach;
}
