package hu.cubix.cubixschool.web;

import hu.cubix.cubixschool.mapper.TeacherMapper;
import hu.cubix.cubixschool.model.Teacher;
import hu.cubix.cubixschool.repository.TeacherRepository;
import hu.webuni.cubixschool.api.TeacherControllerApi;
import hu.webuni.cubixschool.api.model.TeacherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeacherController implements TeacherControllerApi {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public ResponseEntity<List<TeacherDto>> findAll() {
        return ResponseEntity.ok(teacherMapper.entitiesToDtos(teacherRepository.findAll()));
    }

    @Override
    public ResponseEntity<TeacherDto> findById(Integer id) {
        Teacher course = teacherRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(teacherMapper.entityToDto(course));
    }
}
