package hu.cubix.cubixschool.web;

import hu.cubix.cubixschool.mapper.StudentMapper;
import hu.cubix.cubixschool.model.Student;
import hu.cubix.cubixschool.repository.StudentRepository;
import hu.webuni.cubixschool.api.StudentControllerApi;
import hu.webuni.cubixschool.api.model.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController implements StudentControllerApi {


    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public ResponseEntity<List<StudentDto>> findAll1() {
        return ResponseEntity.ok(studentMapper.entitiesToDtos(studentRepository.findAll()));
    }

    @Override
    public ResponseEntity<StudentDto> findById1(Integer id) {
        Student course = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(studentMapper.entityToDto(course));
    }

    @Override
    public ResponseEntity<Void> deletePicture(Long studentId) {
        try {
            Path filepath = Paths.get("uploads", studentId + " student ID" + ".jpg");
            if (Files.deleteIfExists(filepath)) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Resource> getPicture(Long studentId) {
        try {
            Path filepath = Paths.get("uploads", studentId + " student ID" + ".jpg");
            if (Files.exists(filepath)) {
                Resource resource = new UrlResource(filepath.toUri());
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<String> uploadPicture(Long studentId, MultipartFile content) {
        try {
            Path filepath = Paths.get("uploads", studentId + " student ID" + ".jpg");
            Files.write(filepath, content.getBytes());
            return ResponseEntity.ok("File uploaded: " + filepath);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed.");
        }
    }
}
