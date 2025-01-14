package hu.cubix.cubixschool.web;


import hu.cubix.cubixschool.mapper.StudentMapper;
import hu.cubix.cubixschool.model.Student;
import hu.cubix.cubixschool.repository.StudentRepository;
import hu.webuni.cubixschool.api.model.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
// @RestController
// @RequestMapping("/api/student")
public class StudentControllerOld {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @GetMapping
    public List<StudentDto> findAll() {
        return studentMapper.entitiesToDtos(studentRepository.findAll());
    }

    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable final int id) {
        Student course = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return studentMapper.entityToDto(course);
    }


}
