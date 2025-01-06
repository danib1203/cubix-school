package hu.cubix.cubixschool.web;

import hu.cubix.cubixschool.dto.TeacherDto;
import hu.cubix.cubixschool.mapper.TeacherMapper;
import hu.cubix.cubixschool.model.Teacher;
import hu.cubix.cubixschool.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @GetMapping
    public List<TeacherDto> findAll() {
        return teacherMapper.entitiesToDtos(teacherRepository.findAll());
    }

    @GetMapping("/{id}")
    public TeacherDto findById(@PathVariable final int id) {
        Teacher course = teacherRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return teacherMapper.entityToDto(course);
    }


}
