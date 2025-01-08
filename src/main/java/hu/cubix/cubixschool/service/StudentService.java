package hu.cubix.cubixschool.service;

import hu.cubix.cubixschool.model.Student;
import hu.cubix.cubixschool.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final SemesterService semesterService;


  //  @Scheduled(cron = "#{@schoolConfigProperties.freeSemestersCron}")
  //  @Async
  //  public void getUsedFreeSemesters() {
  //      System.out.println("getUsedFreeSemesters called");
  //      findAll().forEach(this::updateStudentUsedFreeSemesters);
  //  }

    private void updateStudentUsedFreeSemesters(Student student) {
        student.setUsedFreeSemesters(semesterService.usedFreeSemesters(student.getId()));
        studentRepository.save(student);
    }

    @Transactional
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

}
